package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRaceGroup {
	private static final int MOVING_STANDARD_NUMBER = 4;
	private static final String HYPHEN = "-";
	private static final String EMPTY = "";
	private final List<CarRace> carRaceGroup;

	public CarRaceGroup(CarCount carCount, CarRaceCount carRaceCount) {
		this.carRaceGroup = Collections.unmodifiableList(startCarRace(carCount, carRaceCount));
	}

	private List<CarRace> startCarRace(CarCount carCount, CarRaceCount carRaceCount) {
		List<CarRace> carRacePosition = new ArrayList<>();
		for (int i = 0; i < carRaceCount.count(); i++) {
			carRacePosition.add(carDrivingResult(carCount.count(), carRacePosition));
		}

		return carRacePosition;
	}

	private CarRace carDrivingResult(int carCount, List<CarRace> carRacePosition) {
		String[] carRace = new String[carCount];
		for (int i = 0; i < carCount; i++) {
			carRace[i] = carDriving(i, carRacePosition);
		}

		return new CarRace(carRace);
	}

	private String carDriving(int index, List<CarRace> carRacePosition) {
		int size = carRacePosition.size();
		if (size > 0) {
			return carRacePosition.get(size - 1).position(index) + changeNumberToHyphen();
		}
		return changeNumberToHyphen();
	}

	private String changeNumberToHyphen() {
		if (Driving.drive() >= MOVING_STANDARD_NUMBER) {
			return HYPHEN;
		}
		return EMPTY;
	}

	public int size() {
		return carRaceGroup.size();
	}

	public int carCountByMoving(int index) {
		return carRaceGroup.get(index).size();
	}

	public String carLocation(int carRaceCount, int carNumber) {
		return carRaceGroup.get(carRaceCount).position(carNumber);
	}
}
