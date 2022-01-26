package model;

public class MemberDTO {
	private String email;
	private String pw;
	private String nickname;
	private String dong;

	public MemberDTO(String email, String pw, String nickname, String dong) {
		super();
		this.email = email;
		this.pw = pw;
		this.nickname = nickname;
		this.dong = dong;
	}
	
	public MemberDTO(String email, String pw) {
		super();
		this.email = email;
		this.pw = pw;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

}
