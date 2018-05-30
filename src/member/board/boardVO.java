package member.board;

import java.util.Date;

public class boardVO {
	private int board_num;
	private String board_subject;
	private String board_content;
	private int board_readhit;
	private Date board_regdate;
	private String board_admin;
	private int board_commentno;
	private String board_orgname;
	private String board_savname;
	
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
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getBoard_readhit() {
		return board_readhit;
	}
	public void setBoard_readhit(int board_readhit) {
		this.board_readhit = board_readhit;
	}
	public Date getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(Date board_regdate) {
		this.board_regdate = board_regdate;
	}
	public String getBoard_admin() {
		return board_admin;
	}
	public void setBoard_admin(String board_admin) {
		this.board_admin = board_admin;
	}
	public int getBoard_commentno() {
		return board_commentno;
	}
	public void setBoard_commentno(int board_commentno) {
		this.board_commentno = board_commentno;
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
	


}
