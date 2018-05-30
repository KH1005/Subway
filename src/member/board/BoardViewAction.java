package member.board;

import com.opensymphony.xwork2.ActionSupport;

import admin.board.AdminboardVO;
import member.board.cboardVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class BoardViewAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private AdminboardVO paramClass = new AdminboardVO(); //파라미터를 저장할 객체
	private AdminboardVO resultClass = new AdminboardVO(); //쿼리 결과 값을 저장할 객체
	
	private List<cboardVO> commentlist = new ArrayList<cboardVO>();
	
	private cboardVO cClass = new cboardVO();
	private cboardVO cResult = new cboardVO();
	
	private int currentPage;

	private int board_num;
	private int originno;
	
	private String comment_password;
	
    private String fileUploadPath = "C:\\Java\\upload\\";

	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;

	// 생성자
	public BoardViewAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	// 상세보기
	public String execute() throws Exception {

		// 해당 글의 조회수 +1.
		paramClass.setBoard_num(getBoard_num());
		sqlMapper.update("updateReadHit", paramClass);

		// 해당 번호의 글을 가져온다.
		
		resultClass = (AdminboardVO) sqlMapper.queryForObject("selectOne", getBoard_num());
		commentlist = sqlMapper.queryForList("commentSelectAll", getOriginno());

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

	public List<cboardVO> getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(List<cboardVO> commentlist) {
		this.commentlist = commentlist;
	}

	public cboardVO getcClass() {
		return cClass;
	}

	public void setcClass(cboardVO cClass) {
		this.cClass = cClass;
	}

	public cboardVO getcResult() {
		return cResult;
	}

	public void setcResult(cboardVO cResult) {
		this.cResult = cResult;
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

	public int getOriginno() {
		return originno;
	}

	public void setOriginno(int originno) {
		this.originno = originno;
	}

	public String getComment_password() {
		return comment_password;
	}

	public void setComment_password(String comment_password) {
		this.comment_password = comment_password;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	

}