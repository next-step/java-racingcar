package im.juniq.racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private List<Car> cars = new ArrayList<>();

	public RacingGame(Car... car) {
		cars.addAll(Arrays.asList(car));
	}

	public void createCars(String[] carNames, MovingStrategy movingStrategy) {
		for (String carName : carNames) {
			cars.add(new Car(carName, movingStrategy));
		}
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}

	private List<Car> findByTopPosition() {
		int topPosition = cars.stream()
				.mapToInt(Car::getPosition)
				.max().orElseThrow(()  -> new RuntimeException("position 수치가 가장 높은 차를 구할 수 없음."));

		return cars.stream().filter(car -> topPosition == car.getPosition())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public String getWinner() {
		String winner = "";
		for (Car car: findByTopPosition()) {
			winner += addSeparatorIfNotEmpty(winner) + car.getName();
		}
		return winner;
	}

	private String addSeparatorIfNotEmpty(String winner) {
		if (!winner.isEmpty()) {
			return ", ";
		}
		return "";
	}

	public String getScore() {
		String carsStatus = "";
		for (Car car: cars) {
			carsStatus += car.getStatus() + addNewLine();
		}
		return carsStatus;
	}

	private String addNewLine() {
		return "\n";
	}
}
