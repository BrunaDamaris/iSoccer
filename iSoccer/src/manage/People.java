package manage;

public class People {
	private String fullname;
	private String email;
	private String cpf;
	private String phonenumber;
	
	public People(String name,String nemail,String ncpf,String pnumber) {
		setFullname(name);
		setEmail(nemail);
		setCpf(ncpf);
		setPhonenumber(pnumber);
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
