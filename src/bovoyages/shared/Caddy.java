package bovoyages.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Caddy implements Serializable {
	private List<Voyage> voyages = new ArrayList<Voyage>();
	
	public void add(Voyage voyage){
		voyages.add(voyage);
	}
	
	public void remove(Voyage voyage){
		voyages.remove(voyage);
	}
	
	public void clear(){
		voyages.clear();
	}
	
	public int count(){
		return voyages.size();
	}
	
	public List<Voyage> getVoyages(){
		return voyages;
	}
	
	public double getPrixTotal(){
		double total = 0;
		for(Voyage v : voyages){
			total += v.getPrixTotal();
		}
		return total;
	}
}
