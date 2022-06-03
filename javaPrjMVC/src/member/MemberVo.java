package member;

public class MemberVo {
	
	private String id;
	private String pwd;
	private String nick;
	private String phone;
	private String gender;

	
	public MemberVo(String id, String pwd, String nick, String phone, String gender) {
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.phone = phone;
		this.gender = gender;
	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", phone=" + phone + ", gender=" + gender
				+ "]";
	}
	
}
