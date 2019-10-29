package step2.dto;

import step2.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRaceSnapshot {

	private final List<CarDto> snapshots = new ArrayList<>();

	private CarRaceSnapshot(List<Car> cars) {
		for (Car car : cars) {
			snapshots.add(CarDto.of(car));
		}
	}

	public static CarRaceSnapshot of(List<Car> cars) {
		return new CarRaceSnapshot(cars);
	}

	public List<CarDto> getSnapshot() {
		return snapshots;
	}

}
