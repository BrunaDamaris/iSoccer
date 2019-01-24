package manage;

public class Doctor extends TeamEmployees{
	private String CRM;
	
	public Doctor(String name, String nemail, String ncpf, String pnumber,String ntype,double nsalary,String ncrm) {
		super(name, nemail, ncpf, pnumber,ntype,nsalary);
		setCRM(ncrm);
	}
	
	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}
	
	
}
