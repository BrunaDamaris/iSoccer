package manage;

import java.util.ArrayList;

public class TeamSupporters extends People implements Inter{
	private String address;
	private String supportertype;
	private double contribution;
	private String paymentstatus;
	
	public TeamSupporters(String name, String nemail, String ncpf, String pnumber,String saddress,String stype,double ncontribution) {
		super(name, nemail, ncpf, pnumber);
		setAddress(saddress);
		setSupportertype(stype);
		setContribution(ncontribution);
		setPaymentstatus("1");
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getContribution() {
		return contribution;
	}
	public void setContribution(double contribution) {
		this.contribution = contribution;
	}
	public String getSupportertype() {
		return supportertype;
	}
	public void setSupportertype(String supportertype) {
		this.supportertype = supportertype;
	}
	public String getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	@Override
	public void add(ArrayList<People> array, Object P) {
		array.add((TeamSupporters) P);
	}
}
