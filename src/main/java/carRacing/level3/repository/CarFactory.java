package carRacing.level3.repository;

import java.util.HashMap;

public class CarFactory {

	private static final Integer DEFAULT_STATUS = 1;
	private static final Integer MOVE_CAR_STATUS = 1;
	private static HashMap<Integer, Integer> carMap = new HashMap<>();

	public void initStatus(int carNum) {
		carMap.put(carNum, DEFAULT_STATUS);
	}

	public Integer carStatus(int carNum) {
		return carMap.get(carNum);
	}

	public void saveStatus(int carNum, int newStatus) {
		carMap.put(carNum, newStatus);
	}

	public Integer updateStatus(int carNum) {

		int status = (carNum);
		status += MOVE_CAR_STATUS;

		return status;
	}

}
