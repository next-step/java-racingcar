package carRacing.level3.repository;

import java.util.HashMap;

public class CarFactory {

	private static final Integer DEFAULT_LOCATION = 1;
	private static final Integer MOVE_CAR_LOCATION = 1;
	private static HashMap<Integer, Integer> carMap = new HashMap<>();

	public void initCarLocation(int carNum) {
		carMap.put(carNum, DEFAULT_LOCATION);
	}

	public Integer carLocation(int carNum) {
		return carMap.get(carNum);
	}

	public void saveCarLocation(int carNum, int newLocation) {
		carMap.put(carNum, newLocation);
	}

	public Integer moveCarLocation(int carNum) {

		int currentLocation = carNum;
		currentLocation += MOVE_CAR_LOCATION;

		return currentLocation;
	}

}
