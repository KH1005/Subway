package admin;

import com.opensymphony.xwork2.ActionSupport;
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
	
	private boardVO paramClass;
	private boardVO resultClass;

	
	private int currentPage;
	
	private int board_num;
	private String board_subject;
	private String board_admin;
	private String board_content;
	private String board_orgname;
	private String board_savname;
	Calendar today = Calendar.getInstance();
	
	
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
		
		paramClass = new boardVO();
		resultClass = new boardVO();
		
		paramClass.setBoard_subject(getBoard_subject());
		paramClass.setBoard_admin(getBoard_admin());
		paramClass.setBoard_content(getBoard_content());
		paramClass.setBoard_regdate(today.getTime());
		
		
		sqlMapper.insert("insertBoard", paramClass);
		return SUCCESS;
	}

	public boardVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(boardVO paramClass) {
		this.paramClass = paramClass;
	}

	public boardVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(boardVO resultClass) {
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

	
	

	

}
