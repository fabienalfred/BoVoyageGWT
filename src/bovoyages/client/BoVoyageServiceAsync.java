package bovoyages.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import bovoyages.shared.Destination;
import bovoyages.shared.DestinationResume;

public interface BoVoyageServiceAsync {

	void getAllDestinationsResumes(AsyncCallback<List<DestinationResume>> listDestinationsResumes);
	void getDestinationById(int id, AsyncCallback<Destination> destination);
	
}
