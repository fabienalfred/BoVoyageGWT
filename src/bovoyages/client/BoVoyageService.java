package bovoyages.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import bovoyages.shared.Destination;
import bovoyages.shared.DestinationResume;

@RemoteServiceRelativePath("BoVoyageService")
public interface BoVoyageService extends RemoteService {

	List<DestinationResume> getAllDestinationsResumes();
	Destination getDestinationById(int id);
}
