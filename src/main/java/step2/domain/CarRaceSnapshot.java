package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRaceSnapshot {

	private final List<Integer> snapshots = new ArrayList<>();

	CarRaceSnapshot(List<Car> cars) {
		for (Car car : cars) {
			snapshots.add(car.getStep());
		}
	}

	public List<Integer> getSnapshot() {
		return snapshots;
	}

}
