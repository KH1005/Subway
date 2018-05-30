package admin.board;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.io.IOException;

public class AdminDeleteAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private AdminboardVO paramClass; //파라미터를 저장할 객체
	private AdminboardVO resultClass; //쿼리 결과 값을 저장할 객체

	private int currentPage;	//현재 페이지
	
	private String fileUploadPath = "C:\\Java\\upload\\";
	
	private int board_num;
	
	
	// 생성자
	public AdminDeleteAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	// 게시글 글 삭제
	public String execute() throws Exception {
		
		//파라미터와 리절트 객체 생성.
		paramClass = new AdminboardVO();
		resultClass = new AdminboardVO();
		
		// 해당 번호의 글을 가져온다.
		resultClass = (AdminboardVO) sqlMapper.queryForObject("selectOne", getBoard_num());

		//서버 파일 삭제
		File deleteFile = new File(fileUploadPath + resultClass.getBoard_savname());
		deleteFile.delete();

		// 삭제할 항목 설정.
		paramClass.setBoard_num(getBoard_num());
				
		// 삭제 쿼리 수행.
		sqlMapper.update("deleteBoard", paramClass);

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

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	

}
