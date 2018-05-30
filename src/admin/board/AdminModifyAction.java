package admin.board;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class AdminModifyAction extends ActionSupport {
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private AdminboardVO paramClass; //파라미터를 저장할 객체
	private AdminboardVO resultClass; //쿼리 결과 값을 저장할 객체

	private int currentPage;	//현재 페이지
	
	private int board_num;
	private String board_subject;
	private String board_admin;
	private String board_content;
	private String old_file;

	private File upload; //파일 객체
	private String uploadContentType; //컨텐츠 타입
	private String uploadFileName; //파일 이름
	private String fileUploadPath = "C:\\Java\\upload\\"; //업로드 경로.

	// 생성자
	public AdminModifyAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	// 게시글 수정
	public String execute() throws Exception {
		
		//파라미터와 리절트 객체 생성.
		paramClass = new AdminboardVO();
		resultClass = new AdminboardVO();

		// 수정할 항목 설정.
		paramClass.setBoard_num(getBoard_num());
		paramClass.setBoard_subject(getBoard_subject());
		paramClass.setBoard_admin(getBoard_admin());
		paramClass.setBoard_content(getBoard_content());

		// 일단 항목만 수정한다.
		sqlMapper.update("updateBoard", paramClass);

		// 수정할 파일이 업로드 되었다면 파일을 업로드하고 DB의 file 항목을 수정함.
		if (getUpload() != null) {
			
			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + getBoard_num();
		           String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
			
			//이전 파일 삭제
			File deleteFile = new File(fileUploadPath + getOld_file());
			deleteFile.delete();
			
			//새 파일 업로드
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			//파일 정보 파라미터 설정.
			paramClass.setBoard_orgname(getUploadFileName());
			paramClass.setBoard_savname(file_name + "." + file_ext);
			
			//파일 정보 업데이트.
			sqlMapper.update("updateFile", paramClass);
		}

		// 수정이 끝나면 view 페이지로 이동.
		resultClass = (AdminboardVO) sqlMapper.queryForObject("selectOne", getBoard_num());

		return SUCCESS;
	}

	public AdminboardVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(AdminboardVO paramClass) {
		this.paramClass = paramClass;
	}

	public AdminboardVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(AdminboardVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getBoard_subject() {
		return board_subject;
	}

	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}

	public String getBoard_admin() {
		return board_admin;
	}

	public void setBoard_admin(String board_admin) {
		this.board_admin = board_admin;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getOld_file() {
		return old_file;
	}

	public void setOld_file(String old_file) {
		this.old_file = old_file;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	
}

