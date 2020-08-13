package step5.domain;

import step5.MovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> racingCars;

	public Cars(List<Car> racingCars) {
		this.racingCars = racingCars;
	}

	public Cars(String names) {
		racingCars = new ArrayList<>();
		String[] separatedNames = names.split(",");
		for (String separatedName : separatedNames) {
			racingCars.add(new Car(separatedName));
		}
	}

	public List<Car> getRacingCars() {
		return racingCars;
	}

	public Cars findWinner() {
		return new Cars(
				racingCars.stream()
						.filter(car -> car.getRecord() == maxRecord())
						.collect(Collectors.toList())
		);
	}

	private int maxRecord() {
		OptionalInt maybeMax = racingCars.stream().mapToInt(Car::getRecord).max();
		if (maybeMax.isPresent()) {
			return maybeMax.getAsInt();
		}
		return 0;
	}

	public Cars playRound(MovingStrategy moving) {
		for (Car car : racingCars) {
			car.moveForward(moving.getMovingNumber());
		}
		return this;
	}

}
