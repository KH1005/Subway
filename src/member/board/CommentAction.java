package member.board;


import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;



public class CommentAction extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private cboardVO paramClass;
	private cboardVO resultClass;

	private int comment_num;
	private int currentPage;

	private String comment_name;
	private String comment_password;
	private String comment_content;
	private int originno;

	Calendar today = Calendar.getInstance();

	public CommentAction() throws IOException
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
		
		paramClass = new cboardVO();
		resultClass = new cboardVO();
		
		paramClass.setOriginno(getOriginno());
		paramClass.setComment_name(getComment_name());
		paramClass.setComment_password(getComment_password());	
		
		paramClass.setComment_content(getComment_content());
		paramClass.setComment_date(today.getTime());
		
		sqlMapper.insert("insertComment", paramClass);
		

		return SUCCESS;
	}

	public cboardVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(cboardVO paramClass) {
		this.paramClass = paramClass;
	}

	public cboardVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(cboardVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getBoard_num() {
		return comment_num;
	}

	public void setBoard_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getComment_name() {
		return comment_name;
	}

	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}

	public String getComment_password() {
		return comment_password;
	}

	public void setComment_password(String comment_password) {
		this.comment_password = comment_password;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public int getOriginno() {
		return originno;
	}

	public void setOriginno(int originno) {
		this.originno = originno;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	
	
	

}