package admin.board;

import com.opensymphony.xwork2.ActionSupport;

import admin.board.AdminboardVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.io.File;
import org.apache.commons.io.FileUtils;


public class AdminWriteAction extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private AdminboardVO paramClass;
	private AdminboardVO resultClass;

	
	private int currentPage;
	
	private int board_num;
	private String board_subject;
	private String board_admin;
	private String board_content;
	private String board_orgname;
	private String board_savname;
	Calendar today = Calendar.getInstance();
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String fileUploadPath="C:\\Java\\upload\\";
	
	
	public AdminWriteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();

	}
	
	public String form() throws Exception
	{
		return SUCCESS;
		
	}
	
	public String execute() throws Exception {
		
		paramClass = new AdminboardVO();
		resultClass = new AdminboardVO();
		
		paramClass.setBoard_subject(getBoard_subject());
		paramClass.setBoard_admin(getBoard_admin());
		paramClass.setBoard_content(getBoard_content());
		paramClass.setBoard_regdate(today.getTime());
		
		
		sqlMapper.insert("insertBoard", paramClass);
		
	   if(getUpload() != null)
		{
		   	System.out.println("in");
			resultClass = (AdminboardVO) sqlMapper.queryForObject("selectLastNo");
			
			String file_name = "file_" + resultClass.getBoard_num();
			String file_ext = getUploadFileName().substring(
					getUploadFileName().lastIndexOf('.') + 1,
					getUploadFileName().length()
					);
			
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			paramClass.setBoard_num(resultClass.getBoard_num());
			paramClass.setBoard_orgname(getUploadFileName());
			paramClass.setBoard_savname(file_name+"."+file_ext);
			
			sqlMapper.update("updateFile", paramClass);
		}
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		AdminWriteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		AdminWriteAction.sqlMapper = sqlMapper;
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

	public String getBoard_orgname() {
		return board_orgname;
	}

	public void setBoard_orgname(String board_orgname) {
		this.board_orgname = board_orgname;
	}

	public String getBoard_savname() {
		return board_savname;
	}

	public void setBoard_savname(String board_savname) {
		this.board_savname = board_savname;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
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
