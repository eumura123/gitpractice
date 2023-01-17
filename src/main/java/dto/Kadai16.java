package dto;

public class Kadai16 {
	private String name;
	private int age;
	private String gender;
	private int tel;
	private String mail;
	private String pass;
	private	String hashpass;
	private String salt;
	
	public Kadai16(String name,int age,String gender,int tel,String mail,String pass,String hashpass,String salt) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.tel = tel;
		this.mail = mail;
		this.pass = pass;
		this.hashpass = hashpass;
		this.salt = salt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getHashpass() {
		return hashpass;
	}

	public void setHashpass(String hashpass) {
		this.hashpass = hashpass;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
}
