package manage;

public class Stadium extends Resources{
	private long capacity;
	private int numberofbathrooms;
	private int numberofdiners;
	
	public Stadium(String resourcetype,int ecapacity,int bathrooms,int diners) {
		super(resourcetype);
		setCapacity(ecapacity);
		setNumberofbathrooms(bathrooms);
		setNumberofdiners(diners);
	}
	
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	public int getNumberofbathrooms() {
		return numberofbathrooms;
	}
	public void setNumberofbathrooms(int numberofbathrooms) {
		this.numberofbathrooms = numberofbathrooms;
	}
	public int getNumberofdiners() {
		return numberofdiners;
	}
	public void setNumberofdiners(int numberofdiners) {
		this.numberofdiners = numberofdiners;
	}
}
