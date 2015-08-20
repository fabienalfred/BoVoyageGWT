package bovoyages.shared;

import java.io.Serializable;

public class DestinationResume implements Serializable{
	private int id;
	private String region;
	private String description;
	private String image;
	
	public DestinationResume() {
	}
	
	public DestinationResume(int id, String region, String description, String image) {
		this.id = id;
		this.region = region;
		this.description = description;
		this.image = image;
	}
	
	public DestinationResume(Destination destination){
		this.id = destination.getId();
		this.region = destination.getRegion();
		this.description = destination.getDescription();
		if(destination.getImages().size()>0){
			this.image = (destination.getImages().toArray(new String[]{}))[0];
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "DestinationResume [id=" + id + ", region=" + region + ", description=" + description + ", image=" + image + "]";
	}
	
	
	
}
