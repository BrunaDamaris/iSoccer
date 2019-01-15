package manage;

import java.util.ArrayList;

public class Resources {
	private String isAvailable;
	private String resourcetype;
	
	public Resources(String resourcetype) {
		setResourcetype(resourcetype);
		setIsAvailable("1");
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(String resourcetype) {
		this.resourcetype = resourcetype;
	}
	
	public static void addBus(ArrayList<Resources> teamresources,String resourcetype) {
		Resources newr = new Resources(resourcetype);
		if(teamresources.contains(newr)) System.out.println("Nao foi possivel adicionar, recurso ja existe e esta disponivel.");
		else {
			teamresources.add(newr);
			System.out.println("Adicionado.");	
		}
	}
	public static void addStadium(ArrayList<Resources> teamresources,String resourcetype,int capacity,int bathrooms,int diners) {
		Resources newr = new Stadium(resourcetype,capacity,bathrooms,diners);
		if(teamresources.contains(newr)) System.out.println("Nao foi possivel adicionar, recurso ja existe e esta disponivel.");
		else {
			teamresources.add(newr);
			System.out.println("Adicionado.");	
		}
	}
	public static void addCenter(ArrayList<Resources> teamresources,String resourcetype,int dormitories) {
		Resources newr = new TCenter(resourcetype,dormitories);
		if(teamresources.contains(newr)) System.out.println("Nao foi possivel adicionar, recurso ja existe e esta disponivel.");
		else {
			teamresources.add(newr);
			System.out.println("Adicionado.");	
		}
	}
}
