package bovoyages.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import bovoyages.shared.DatesVoyage;
import bovoyages.shared.Destination;
import bovoyages.shared.DestinationResume;

public class BoVoyageEntryPoint implements EntryPoint {

	private final BoVoyageServiceAsync service = GWT.create(BoVoyageService.class);
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel datesPanel = new VerticalPanel();
	
	
	@Override
	public void onModuleLoad() {
		Button showAllButton = new Button("All");
		RootPanel.get("menu").add(showAllButton);
		showAllButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showAll();
			}
		});

		Button clearButton = new Button("Clear");
		RootPanel.get("menu").add(clearButton);
		clearButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				vPanel.clear();
			}
		});
	}

	public void showAll() {
		service.getAllDestinationsResumes(new AsyncCallback<List<DestinationResume>>() {
			@Override
			public void onSuccess(List<DestinationResume> result) {
				vPanel.clear();
				for(DestinationResume d : result) {
					HorizontalPanel hPanel = new HorizontalPanel();
					Label region = new Label(d.getRegion());
					Image img = new Image("images/"+d.getImage());
					hPanel.add(region);
					hPanel.setCellHeight(region,"100px");
					hPanel.setCellWidth(region,"100px");
					hPanel.add(img);
					hPanel.setCellHeight(img,"100px");
					hPanel.setCellWidth(img,"100px");
					Button voirDates = createButton(d.getId());
					hPanel.add(voirDates);
					hPanel.setSpacing(10);
					vPanel.add(hPanel);
				}
				RootPanel.get("main").add(vPanel);
			}
			@Override
			public void onFailure(Throwable caught) {
				RootPanel.get("main").add(new Label("ERROR"));
			}
		});
	}
	
	public Button createButton(final int id) {
		Button button = new Button("Détails");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				datesPanel.clear();
				service.getDestinationById(id, new AsyncCallback<Destination>() {
					@Override
					public void onSuccess(Destination result) {
						for(DatesVoyage dv : result.getDates()) {
							HorizontalPanel hp = new HorizontalPanel();
							String depart = DateTimeFormat
											.getFormat("EEEE MM yyyy")
											.format(dv.getDepart());
							String retour = DateTimeFormat
											.getFormat("EEEE MM yyyy")
											.format(dv.getRetour());
							hp.add(new Label("Départ : " + depart + ","));
							hp.add(new Label("retour : " + retour + ","));
							hp.add(new Label("prix : " + String.valueOf(dv.getPrix()) + "€"));
							hp.setSpacing(10);
							datesPanel.add(hp);
							RootPanel.get("dates").add(datesPanel);
						}
					}
					@Override
					public void onFailure(Throwable caught) {
						RootPanel.get("dates").add(new Label("ERROR"));
					}
				});
			}
		});
		return button;
	}
}
