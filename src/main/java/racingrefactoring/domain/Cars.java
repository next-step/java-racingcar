package racingrefactoring.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> carList;

	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	public Cars(Car... car) {
		carList = new ArrayList<>(Arrays.asList(car));
	}

	public Cars(String[] carNames) {
		List<Car> list = new ArrayList<>();
		for (String carName : carNames) {
			list.add(new Car(carName.trim()));
		}
		carList = list;
	}

	public Cars add(Car car) {
		this.carList.add(car);
		return this;
	}

	public Cars moveForward() {
		for (Car car : carList) {
			car.moveForward(new RandomMoving());
		}
		return this;
	}

	public List<Car> list() {
		return Collections.unmodifiableList(carList);
	}

	public int size() {
		return carList.size();
	}

	public Cars findWinners() {
		return findWinners(maxMoveCount());
	}

	private int maxMoveCount() {
		return carList.stream()
		              .max(Comparator.comparing(Car::forwardCount))
		              .orElseGet(() -> new Car(""))
		              .forwardCount();
	}

	private Cars findWinners(int maxMoveCount) {
		return new Cars(carList.stream()
		                       .filter(car -> car.isWinner(maxMoveCount))
		                       .collect(Collectors.toList()));
	}


}
