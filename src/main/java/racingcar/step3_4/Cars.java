package racingcar.step3_4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars createCars(Names carNames) {
		List<Car> cars = new ArrayList<>();
		for (Name name : carNames.getNames()) {
			cars.add(new Car(name));
		}

		return new Cars(cars);
	}

	public void move(RandomValueGenerator randomValueGenerator) {
		for (Car car : cars) {
			car.move(randomValueGenerator);
		}
	}

	public List<Car> determineWinners() {
		return cars.stream()
			.filter(car -> car.getPosition() == getMaxPosition())
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(() -> new NoSuchElementException("우승 위치의 자동차가 존재하지 않습니다."));
	}

	public int getCarsCount() {
		return cars.size();
	}

	public List<Car> getCars() {
		return List.copyOf(this.cars);
	}
}
