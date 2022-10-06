package carRacing.level3.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

	private int maxLocation;
	private List<String> winnerList;

	public Winner(){
		this(new ArrayList<>());
	}

	public Winner(List<String> winnerList) {
		this.winnerList = winnerList;
	}

	public Winner decideWinner(Cars cars) {

		maxLocation = cars.maxCarLocation();

		for (int i = 0; i < cars.totalNum(); i++) {
			addWinner(cars.carLocation(i), cars.carName(i));
		}

		return new Winner(winnerList);
	}

	public void addWinner(int location, String carName) {
		if (maxLocation == location) {
			winnerList.add(carName);
		}
	}

	public List<String> getWinnerList(){
		return winnerList;
	}

}
