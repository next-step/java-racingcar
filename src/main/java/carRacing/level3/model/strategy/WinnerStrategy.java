package carRacing.level3.model.strategy;

import carRacing.level3.model.Cars;
import java.util.ArrayList;
import java.util.List;

public class WinnerStrategy {

	private static int maxLocation;
	List<String> winnerList = new ArrayList<>();

	public List<String> winnerList(Cars cars) {

		maxLocation = cars.maxCarLocation();

		for (int i = 0; i < cars.totalNum(); i++) {
			addWinner(cars.carLocation(i), cars.carName(i));
		}

		return winnerList;
	}

	public void addWinner(int location, String carName) {
		if (maxLocation == location) {
			winnerList.add(carName);
		}
	}

}
