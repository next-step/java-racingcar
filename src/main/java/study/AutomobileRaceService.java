package study;

import java.util.Map;
import java.util.Random;

public class AutomobileRaceService {

	private int carCount;
	private Map<Integer, String> carContainer;

	public AutomobileRaceService(int carCount) {
		this.carCount = carCount;
	}

	public void startRace() {
		setCarContainer();
		for(int i = 1 ; i <= carCount ; ++i) {
			race(i);
		}
	}

	public Map<Integer, String> getCarContainer() {
		return carContainer;
	}

	private void setCarContainer() {
		for(int i = 1 ; i <= carCount ; ++i) {
			carContainer.put(i, "");
		}
	}

	private void race(int keyNumber) {
		boolean raceStatus = getRaceStatus();
		if(raceStatus) {
			carContainer.put(keyNumber, carContainer.get(keyNumber) + "-");
		}
	}

	private boolean getRaceStatus() {
		Random rand = new Random();
		int number =  rand.nextInt(10);
		if(number >= 4) {
			return true;
		}
		return false;
	}
}
