package bovoyages.server;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import bovoyages.shared.BovoyagesFacade;
import bovoyages.shared.DatesVoyage;
import bovoyages.shared.Destination;
import bovoyages.shared.DestinationResume;

public class BovoyageFacadeMock implements BovoyagesFacade{
	private List<Destination> destinations = new ArrayList<Destination>();
	
	public BovoyageFacadeMock() {
		initListeDestinations();
	}
	
	@Override
	public List<DestinationResume> getAllDestinationResume() {
		List<DestinationResume> resumes = new ArrayList<DestinationResume>();
		for(Destination d : destinations)
			resumes.add(new DestinationResume(d));
		return resumes;
	}
	
	@Override
	public List<Destination> getAllDestinations() {
		return destinations;
	}

	@Override
	public Destination getDestinationById(int id) {
		for(Destination d : destinations){
			if(d.getId() == id)
				return d;
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	private void initListeDestinations() {
		int idDatesVoyages = 1;
		Destination destination = new Destination();
		destination.setRegion("Guadeloupe");
		destination.setDescription("Dans un site exceptionnel,en bordure d'un petit lagon turquoise, tout est réuni pour un séjour paradisiaque à la découverte des merveilles de la terre et de la mer");
		destination.setImages(new String[]{"guadeloupe_1.jpg"});
		destination.addSejour(new DatesVoyage(idDatesVoyages++,new GregorianCalendar(2015,6,12).getTime(), new GregorianCalendar(2015,6,22).getTime(), 1359));
		destination.addSejour(new DatesVoyage(idDatesVoyages++,new GregorianCalendar(2015,8,1).getTime(), new GregorianCalendar(2015,8,15).getTime(), 2450));
		destination.addSejour(new DatesVoyage(idDatesVoyages++,new GregorianCalendar(2015,9,3).getTime(), new GregorianCalendar(2015,9,15).getTime(), 2420));
		destination.setId(this.destinations.size()+1);
		this.destinations.add(destination);
		
		destination = new Destination();
		destination.setRegion("Saint-Barthélémy");
		destination.setDescription("Imaginez une île où il fait 26 à 28 °C toute l'année, et où la température de la mer est la même que celle de l'air");
		destination.setImages(new String[]{"saint-barth_1.jpg","saint-barth_2.jpg"});
		destination.addSejour(new DatesVoyage(idDatesVoyages++,new GregorianCalendar(2015,6,3).getTime(), new GregorianCalendar(2015,6,15).getTime(), 2250));
		destination.addSejour(new DatesVoyage(idDatesVoyages++,new GregorianCalendar(2015,7,8).getTime(), new GregorianCalendar(2015,7,18).getTime(), 2300));
		destination.setId(this.destinations.size()+1);
		this.destinations.add(destination);
		
		destination = new Destination();
		destination.setRegion("Canada");
		destination.setDescription("Découvrez la nature généreuse et les grandes villes du Canada en toute saison, grâce aux nombreux circuits que nous avons élaborés.");
		destination.setImages(new String[]{"canada_1.jpg","canada_2.jpg"});
		destination.addSejour(new DatesVoyage(idDatesVoyages++,new GregorianCalendar(2015,8,12).getTime(), new GregorianCalendar(2015,8,20).getTime(), 2950));
		destination.addSejour(new DatesVoyage(idDatesVoyages++,new GregorianCalendar(2015,12,27).getTime(), new GregorianCalendar(2016,1,3).getTime(), 3200));
		destination.setId(this.destinations.size()+1);
		this.destinations.add(destination);
		
		destination = new Destination();
		destination.setRegion("Birmanie");
		destination.setDescription("La Birmanie est un pays passionnant pour tous ceux qui s'interessent à l'art, aux civilisations, à l'hindouisme. Ce pays s'ouvre et a conservé toute la richesse de son patrimoine culturel.");
		destination.setImages(new String[]{"myanmar_1.jpg","myanmar_2.jpg","myanmar_3.jpg"});
		destination.addSejour(new DatesVoyage(idDatesVoyages++,new GregorianCalendar(2015,7,12).getTime(), new GregorianCalendar(2015,7,20).getTime(), 2700));
		destination.addSejour(new DatesVoyage(idDatesVoyages++,new GregorianCalendar(2015,9,10).getTime(), new GregorianCalendar(2015,9,25).getTime(), 2890));
		destination.setId(this.destinations.size()+1);
		this.destinations.add(destination);
	}
}
