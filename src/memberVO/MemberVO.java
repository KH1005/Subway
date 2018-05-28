package memberVO;

import java.sql.Timestamp;

public class MemberVO {
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	public String getMEMBER_PW() {
		return MEMBER_PW;
	}
	public void setMEMBER_PW(String mEMBER_PW) {
		MEMBER_PW = mEMBER_PW;
	}
	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}
	public void setMEMBER_NAME(String mEMBER_NAME) {
		MEMBER_NAME = mEMBER_NAME;
	}
	public String getMEMBER_EMAIL() {
		return MEMBER_EMAIL;
	}
	public void setMEMBER_EMAIL(String mEMBER_EMAIL) {
		MEMBER_EMAIL = mEMBER_EMAIL;
	}
	public int getMEMBER_BIRTH() {
		return MEMBER_BIRTH;
	}
	public void setMEMBER_BIRTH(int i) {
		MEMBER_BIRTH = i;
	}
	public String getMEMBER_SEX() {
		return MEMBER_SEX;
	}
	public void setMEMBER_SEX(String mEMBER_SEX) {
		MEMBER_SEX = mEMBER_SEX;
	}
	public int getMEMBER_PHONE() {
		return MEMBER_PHONE;
	}
	public void setMEMBER_PHONE(int i) {
		MEMBER_PHONE = i;
	}
	public String getMEMBER_ZIPCODE() {
		return MEMBER_ZIPCODE;
	}
	public void setMEMBER_ZIPCODE(String mEMBER_ZIPCODE) {
		MEMBER_ZIPCODE = mEMBER_ZIPCODE;
	}
	public String getMEMBER_ADDRESS() {
		return MEMBER_ADDRESS;
	}
	public void setMEMBER_ADDRESS(String mEMBER_ADDRESS) {
		MEMBER_ADDRESS = mEMBER_ADDRESS;
	}
	public String getMEMBER_PROFILE() {
		return MEMBER_PROFILE;
	}
	public void setMEMBER_PROFILE(String mEMBER_PROFILE) {
		MEMBER_PROFILE = mEMBER_PROFILE;
	}
	public Timestamp getMEMBER_REGDATE() {
		return MEMBER_REGDATE;
	}
	public void setMEMBER_REGDATE(Timestamp mEMBER_REGDATE) {
		MEMBER_REGDATE = mEMBER_REGDATE;
	}
	private String MEMBER_ID;
	private String MEMBER_PW;
	private String MEMBER_NAME;

	private String MEMBER_EMAIL;
	private int MEMBER_BIRTH;
	private String MEMBER_SEX;
	private int MEMBER_PHONE;
	private String MEMBER_ZIPCODE;
	private String MEMBER_ADDRESS;

	private String MEMBER_PROFILE;
	private Timestamp MEMBER_REGDATE;
}