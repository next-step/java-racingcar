package racingCar.domain;

import java.util.List;

public enum Distance {
	Kilometer("-"),
	;

	private final String view;

	Distance(String view) {
		this.view = view;
	}

	public static Distance create() {
		return Kilometer;
	}

	public static String convertDistanceToView(List<Distance> distanceList) {
		StringBuilder view = new StringBuilder();

		for (Distance distance : distanceList) {
			view.append(distance.view);
		}

		return view.toString();
	}
}
