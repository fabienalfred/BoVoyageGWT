package bovoyages.server;

import java.util.Date;
import java.util.List;

import bovoyages.shared.BovoyagesFacade;
import bovoyages.shared.Destination;
import bovoyages.shared.DestinationResume;

public class TestFacade {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BovoyagesFacade facade = new BovoyageFacadeMock();
		
		List<DestinationResume> resumes = facade.getAllDestinationResume();
		System.out.println("==== Résumés des destinations ====");
		for(DestinationResume resume : resumes)
			System.out.println(resume);
		System.out.println();
		
		List<Destination> destinations = facade.getAllDestinations();
		System.out.println("==== Liste des destinations ====");
		for(Destination destination : destinations)
			System.out.println(destination);
		System.out.println();
		
		int id = 1;
		System.out.println("==== Destination id : "+id+" ====");
		Destination destination = facade.getDestinationById(id);
		System.out.println(destination);
	}

}
