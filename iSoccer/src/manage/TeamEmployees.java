package manage;

import java.util.ArrayList;

public class TeamEmployees extends People implements Inter{
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
	
	@Override
	public void add(ArrayList<People> array, Object P) {
		array.add((TeamEmployees) P);
	}
}
