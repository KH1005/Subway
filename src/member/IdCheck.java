package member;

import java.io.Reader;
import java.io.IOException;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import member.MemberVO;

public class IdCheck extends ActionSupport{
   public static Reader reader;
   public static SqlMapClient sqlMapper;
   private MemberVO memberVO;
   private String id;
   private int chkId;
   
   public IdCheck() throws IOException{
      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }
   public String execute() throws Exception{
      memberVO=(MemberVO) sqlMapper.queryForObject("member.idCheck",id);
      if(memberVO == null){
         chkId=0;
      }else{
         chkId=1;
      }
      return SUCCESS;
   }
public MemberVO getMemberVO() {
	return memberVO;
}
public void setMemberVO(MemberVO memberVO) {
	this.memberVO = memberVO;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getChkId() {
	return chkId;
}
public void setChkId(int chkId) {
	this.chkId = chkId;
}
   

   


   

}