package manage;

public class Player extends TeamEmployees{
	private String playertype;
	private String canPlay;
	
	public Player(String name, String nemail, String ncpf, String pnumber,String ntype,double nsalary,String nptype,String status) {
		super(name, nemail, ncpf, pnumber,ntype,nsalary);
		setPlayertype(nptype);
		setCanPlay(status);
	}
	
	public String getPlayertype() {
		return playertype;
	}
	public void setPlayertype(String playertype) {
		this.playertype = playertype;
	}
	public String getCanPlay() {
		return canPlay;
	}
	public void setCanPlay(String canPlay) {
		this.canPlay = canPlay;
	}
}
