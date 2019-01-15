package manage;

public class TCenter extends Resources{
	private int dormitories;
	
	public TCenter(String resourcetype,int numberofdormitories) {
		super(resourcetype);
		setDormitories(numberofdormitories);
	}

	public int getDormitories() {
		return dormitories;
	}

	public void setDormitories(int dormitories) {
		this.dormitories = dormitories;
	}
}
