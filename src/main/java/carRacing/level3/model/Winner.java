package carRacing.level3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winner {

	private List<Car> winnerList;
	private Cars cars;

	public Winner(Cars cars) {
		this(new ArrayList<>(), cars);
	}

	public Winner(List<Car> winnerList, Cars cars) {
		this.winnerList = winnerList;
		this.cars = cars;
	}

	public List<Car> findWinner() {

		Location maxLocation = cars.maxLocation();

		for (int i = 0; i < cars.totalNum(); i++) {
			addWinner(cars.car(i), maxLocation);
		}

		return winnerList;
	}

	private void addWinner(Car car, Location maxCarLocation) {

		if (car.isMaxLocation(maxCarLocation)) {
			winnerList.add(car);
		}
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
