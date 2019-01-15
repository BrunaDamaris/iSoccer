package manage;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamEmployees extends People{
	private double salary;
	private String type;
	
	public TeamEmployees(String name, String nemail, String ncpf, String pnumber,String ntype,double nsalary) {
		super(name, nemail, ncpf, pnumber);
		setSalary(nsalary);
		setType(ntype);
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static void add(ArrayList<People> employees, String newname, String newemail, String newtype,String newcpf, String newphonenumber, double newsalary,Scanner input) {
		People newperson;
		if(newtype.equals("Medico")) {
			String ncrm;
			System.out.println("CRM: ");
			ncrm = input.nextLine();
			newperson = new Doctor(newname,newemail,newcpf,newphonenumber,newtype,newsalary,ncrm);
		}
		else if(newtype.equals("Motorista")) {
			String nlisence;
			System.out.println("Numero de Licenca: ");
			nlisence = input.nextLine(); 
			newperson =  new Driver(newname,newemail,newcpf,newphonenumber,newtype,newsalary,nlisence);
		}
		else if(newtype.equals("Jogador")) {
			String ptype = null,status = null;
			boolean accept = false;
			while(!accept) {
				System.out.println("Tipo de Jogador(volante, zagueiro, meia, goleiro, atacante, lateral esquerdo, lateral direito): ");
				ptype = input.nextLine();
				if(ptype.equals("volante") || ptype.equals("zagueiro") || ptype.equals("meia") || ptype.equals("goleiro") || ptype.equals("atacante") || ptype.equals("lateral esquerdo") || ptype.equals("lateral direito")) accept = true;
				else System.out.println("Tipo nao aceito. Tente novamente.");
			}
			System.out.println("Status do Jogador(Pode Jogar(1) ou Nao pode Jogar(2)): ");
			status = input.nextLine();
			newperson = new Player(newname,newemail,newcpf,newphonenumber,newtype,newsalary,ptype,status);
		}
		else {
			newperson = new TeamEmployees(newname,newemail,newcpf,newphonenumber,newtype,newsalary);
		}
		if(employees.contains(newperson)) {
			System.out.println("Nao foi possivel adicionar. Empregado ja existe");
		}
		else {
			System.out.println("Adicionado com sucesso.");
			employees.add(newperson);
		}
	}
}
