package bovoyages.shared;

import java.util.List;


public interface BovoyagesFacade {
	List<DestinationResume> getAllDestinationResume();
	List<Destination> getAllDestinations();
	Destination getDestinationById(int id);
}
