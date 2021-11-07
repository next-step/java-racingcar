package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRaceGroup {
	private static final int MOVING_STANDARD_NUMBER = 4;
	private final List<CarRace> carRaceGroup;

	public CarRaceGroup(CarCount carCount, CarRaceCount carRaceCount) {
		this.carRaceGroup = Collections.unmodifiableList(startCarRace(carCount, carRaceCount));
	}

	private List<CarRace> startCarRace(CarCount carCount, CarRaceCount carRaceCount) {
		List<CarRace> carRace = new ArrayList<>();
		int loopNumber = carCount.count() * carRaceCount.count();
		int carCountSize = carCount.count();
		for (int i = 0; i < loopNumber; i++) {
			carRace.add(new CarRace(carDriving(i, carCountSize, carRace)));
		}

		return carRace;
	}

	private int carDriving(int index, int carCount, List<CarRace> carRace) {
		if (index - carCount >= 0) {
			int beforeIndex = index - carCount;
			return carRace.get(beforeIndex).getPosition() + driving();
		}

		return driving();
	}

	private int driving() {
		if (Driving.drive() >= MOVING_STANDARD_NUMBER) {
			return 1;
		}
		return 0;
	}

	public int size() {
		return carRaceGroup.size();
	}

	public int carPosition(int index) {
		return carRaceGroup.get(index).getPosition();
	}
}
