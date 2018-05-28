package member;
import java.io.Reader;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import memberVO.MemberVO;



public class JoinForm extends ActionSupport {
	public static Reader reader; 
	public static SqlMapClient sqlMapper; 

	private MemberVO paramClass; 
	private MemberVO resultClass; 
	private 

	public String form() throws Exception{
		return SUCCESS;
		
	}
	
	
	public String execute() throws Exception{
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return SUCCESS;
	}
	
}

	