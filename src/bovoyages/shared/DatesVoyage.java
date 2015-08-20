package bovoyages.shared;

import java.io.Serializable;
import java.util.Date;

public class DatesVoyage implements Serializable
{
	private int id;
	private Date depart;
	private Date retour;
	private double prix;
	
	public DatesVoyage()
	{}
	
	public DatesVoyage(Date depart, Date retour, double prix)
	{
		this.depart = depart;
		this.retour = retour;
		this.prix = prix;
	}
	public DatesVoyage(int id, Date depart, Date retour, double prix)
	{
		this.depart = depart;
		this.retour = retour;
		this.prix = prix;
		this.id = id;
	}

	public Date getDepart()
	{
		return depart;
	}

	public void setDepart(Date depart)
	{
		this.depart = depart;
	}

	public Date getRetour()
	{
		return retour;
	}

	public void setRetour(Date retour)
	{
		this.retour = retour;
	}
	
	public double getPrix()
	{
		return prix;
	}

	public void setPrix(double prix)
	{
		this.prix = prix;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String toString()
	{
		StringBuffer result = new StringBuffer();
		result.append("("+id+") DEP : ").append(depart).append(" - RET : ").append(retour).append(" prix : ").append(prix);
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatesVoyage other = (DatesVoyage) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
