package bovoyages.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import bovoyages.client.BoVoyageService;
import bovoyages.shared.Destination;
import bovoyages.shared.DestinationResume;

public class BoVoyageServiceImpl extends RemoteServiceServlet implements BoVoyageService{

	private static final long serialVersionUID = 1L;
	private BovoyageFacadeMock dao = new BovoyageFacadeMock();

	@Override
	public List<DestinationResume> getAllDestinationsResumes() {
		return dao.getAllDestinationResume();
	}

	@Override
	public Destination getDestinationById(int id) {
		return dao.getDestinationById(id);
	}

}
