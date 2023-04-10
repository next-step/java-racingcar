package racingCar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Distance {
	Kilometer("-"),
	;

	private final String view;

	Distance(String view) {
		this.view = view;
	}

	public static List<Distance> from(int speed) {
		List<Distance> distanceList = new ArrayList<>(Collections.nCopies(speed, Kilometer));

		return distanceList;
	}

	public static String convertDistanceToView(List<Distance> distanceList) {
		StringBuilder view = new StringBuilder();

		for (Distance distance : distanceList) {
			view.append(distance.view);
		}

		return view.toString();
	}
}
