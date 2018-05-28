package member;

import java.io.Reader;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;
import memberVO.MemberVO;
public class Login extends ActionSupport implements SessionAware {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private String member_id;
	private String member_pw;
	private Map session;
	private MemberVO paramClass;
	private MemberVO resultClass;

	public Login() throws Exception {
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

		
	public String loginRequest() throws Exception {
		return SUCCESS;
	}
	
	public String checkId() throws Exception {
		paramClass=new MemberVO();
		paramClass.setMEMBER_ID(member_id);
		paramClass.setMEMBER_PW(member_pw);
		
		MemberVO result =(MemberVO)
				
		sqlMapper.queryForObject("login.checkmember", member_id);
		
		if(result != null && member_pw.equals(result.getMEMBER_PW())){
		
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		Login.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		Login.sqlMapper = sqlMapper;
	}

	public String getM_id() {
		return member_id;
	}

	public void setM_id(String m_id) {
		this.member_id = m_id;
	}

	public String getM_pw() {
		return member_pw;
	}

	public void setM_pw(String m_pw) {
		this.member_pw = m_pw;
	}

	public MemberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(MemberVO paramClass) {
		this.paramClass = paramClass;
	}

	public MemberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(MemberVO resultClass) {
		this.resultClass = resultClass;
	}

	public Map getSession() {
		return session;
	}

}