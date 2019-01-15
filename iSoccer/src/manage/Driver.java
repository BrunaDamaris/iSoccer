package manage;

public class Driver extends TeamEmployees{
	private String licensenumber;
	
	public Driver(String name, String nemail, String ncpf, String pnumber,String ntype,double nsalary,String nlicense) {
		super(name, nemail, ncpf, pnumber,ntype,nsalary);
		setLicensenumber(nlicense);
	}

	public String getLicensenumber() {
		return licensenumber;
	}

	public void setLicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	}


}
