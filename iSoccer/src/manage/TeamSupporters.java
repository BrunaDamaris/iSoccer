package manage;

import java.util.ArrayList;

public class TeamSupporters extends People{
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

	public static void add(ArrayList<People> supporters,String newname, String newemail, String newtype, String newcpf, String newphonenumber,String newaddress,double juniorcontribution,double seniorcontribution,double elitecontribution) {
		People newperson = null;
		if(newtype.equals("Junior")) {
			newperson = new TeamSupporters(newname,newemail,newcpf,newphonenumber,newaddress,newtype,juniorcontribution);
			System.out.println("Valor de contribuicao inicial: R$ " + juniorcontribution);
		}
		else if(newtype.equals("Senior")) {
			newperson = new TeamSupporters(newname,newemail,newcpf,newphonenumber,newaddress,newtype,seniorcontribution);
			System.out.println("Valor de contribuicao inicial: R$ " + seniorcontribution);
		}
		else if(newtype.equals("Elite")) {
			newperson = new TeamSupporters(newname,newemail,newcpf,newphonenumber,newaddress,newtype,elitecontribution);
			System.out.println("Valor de contribuicao inicial: R$ " + elitecontribution);
		}
		if(supporters.contains(newperson)) System.out.println("Nao foi possivel adicionar. Torcedor ja existe.");
		else{
			supporters.add(newperson);
			System.out.println("Adicionado com sucesso.");
		}
	}
}
