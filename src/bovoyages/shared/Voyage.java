package bovoyages.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Voyage implements Serializable
{
	private int nbPersonnes;
	private DatesVoyage datesVoyage;
	private String pays;
	public Voyage()
	{}
	
	public Voyage(DatesVoyage sejour,String pays)
	{
		this.datesVoyage = sejour;
		this.pays = pays;
	}
	public Voyage(DatesVoyage sejour,String pays, int nbPersonnes)
	{
		this(sejour,pays);
		this.nbPersonnes=nbPersonnes;
	}
	
	public void addPersonne()
	{
		this.addPersonne(1);
	}
	public void addPersonne(int nb)
	{
		this.nbPersonnes +=nb;
	}
	public String toString()
	{
		return "Voyage vers "+this.pays+" pour "+
				this.nbPersonnes+
				" personnes - "+this.datesVoyage;
	}

	public int getNbPersonnes()
	{
		return nbPersonnes;
	}

	public void setNbPersonnes(int nbPersonnes)
	{
		this.nbPersonnes = nbPersonnes;
	}

	public String getPays()
	{
		return pays;
	}

	public void setPays(String pays)
	{
		this.pays = pays;
	}

	public DatesVoyage getDatesVoyage()
	{
		return datesVoyage;
	}

	public void setDatesVoyage(DatesVoyage sejour)
	{
		this.datesVoyage = sejour;
	}

	public double getPrixTotal()
	{
		return this.nbPersonnes * this.datesVoyage.getPrix();
	}
}