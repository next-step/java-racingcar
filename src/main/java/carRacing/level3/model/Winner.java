package carRacing.level3.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

	private List<String> winnerList;

	public Winner() {
		this(new ArrayList<>());
	}

	public Winner(List<String> winnerList) {
		this.winnerList = winnerList;
	}

	public Winner decideWinner(Cars cars) {

		for (int i = 0; i < cars.totalNum(); i++) {
			addWinner(cars, i);
		}

		return new Winner(winnerList);
	}

	public void addWinner(Cars cars, int carNum) {
		Location location = cars.carLocation(carNum);
		if (location.isWinner(cars.maxCarLocation())) {
			winnerList.add(cars.carName(carNum));
		}
	}

	public List<String> getWinnerList() {
		return winnerList;
	}

}
