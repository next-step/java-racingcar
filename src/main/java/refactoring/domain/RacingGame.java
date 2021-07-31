package refactoring.domain;

import java.util.List;
import java.util.stream.Collectors;

import strategy.AutoMoveable;
import strategy.Moveable;

public class RacingGame {

	private final Cars cars;
	private static final Moveable MOVEABLE = new AutoMoveable();

	public RacingGame(String carsNames) {
		this.cars = Cars.of(carsNames);
	}

	public List<Car> getRecords() {
		return cars.ofRecord()
				   .getRecords();
	}

	public List<String> getWinnerResults() {
		return cars.ofRecord()
				   .getWinnerRecourds()
				   .stream()
				   .map(Car::getCarName)
				   .collect(Collectors.toList());
	}

	public void move() {
		cars.move(MOVEABLE);
	}
}
