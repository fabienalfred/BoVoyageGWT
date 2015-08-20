package bovoyages.shared;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Destination implements Serializable
{
	private int id;
	private String region;
	private String description;
	private Set<String> images = null;
	private Set<DatesVoyage> dates = new HashSet<DatesVoyage>();
	
	public Destination()
	{}
	
	public Destination(int identifiant, String destination)
	{
		this.id = identifiant;
		this.region = destination;
	}

	public Set<DatesVoyage> getDates()
	{
		return dates;
	}

	public void setDates(Set<DatesVoyage> list)
	{
		this.dates = list;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(String destination)
	{
		this.region = destination;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int identifiant)
	{
		this.id = identifiant;
	}

	public Set<String> getImages()
	{
		return images;
	}

	public void setImages(Set<String> list)
	{
		this.images = list;
	}
	
	public void setImages(String[] images){
		this.images = new HashSet<String>();
		for(String image : images)
			this.images.add(image);
	}
	
	public void addImage(String image)
	{
		images.add(image);
	}
	
	public void addSejour(DatesVoyage sejour)
	{
		this.dates.add(sejour);
	}
	
	public DatesVoyage getDatesVoyage(int id)
	{
		DatesVoyage sejour = null;
		Iterator<DatesVoyage> it = this.dates.iterator();
		while(it.hasNext())
		{
			sejour = (DatesVoyage)it.next();
			if(sejour.getId()==id)
				break;
		}
		return sejour;
	}
	
	public DatesVoyage getSejour(String id)
	{
		return this.getDatesVoyage(Integer.parseInt(id));
	}
	
	public String toString()
	{
		StringBuffer result = new StringBuffer("\n\n");
		result.append(region).append("\n").append(description);
		result.append("\n IMAGES : ");
		for(String img : images){
			result.append(img).append(" ");
		}
		for(DatesVoyage dates : this.dates){
			result.append("\n\t").append(dates);
		}
		return result.toString();
	}
}
