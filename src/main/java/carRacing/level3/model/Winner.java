package carRacing.level3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winner {

	private List<String> winnerList;

	public Winner() {
		this(new ArrayList<>());
	}

	public Winner(List<String> winnerList) {
		this.winnerList = winnerList;
	}

	public Winner decideWinner(Cars cars) {

		Location maxLocation = cars.maxLocation();

		for (int i = 0; i < cars.totalNum(); i++) {
			addWinner(cars.car(i),maxLocation);
		}

		return new Winner(winnerList);
	}

	private void addWinner(Car car,Location maxCarLocation) {

		if (car.isMaxLocation(maxCarLocation)){
			winnerList.add(car.carName());
		}
	}

	public List<String> getWinnerList() {
		return winnerList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Winner winner = (Winner) o;
		return Objects.equals(winnerList, winner.winnerList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winnerList);
	}
}
