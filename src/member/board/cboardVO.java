package member.board;
import java.util.Date;

public class cboardVO {
	
	private int originno;
	private int comment_number;
	private String comment_name;
	private String comment_password;
	private String comment_content;
	private Date comment_date;
	
	public int getOriginno() {
		return originno;
	}
	public void setOriginno(int originno) {
		this.originno = originno;
	}
	public int getComment_number() {
		return comment_number;
	}
	public void setComment_number(int comment_number) {
		this.comment_number = comment_number;
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
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	

}
