package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceModel {
	private int remainingRounds;
	private List<CarModel> cars = new ArrayList<>();

	public RaceModel(int rounds, int carAmount) {
		this.remainingRounds = rounds;
		for (int i = 0; i < carAmount; i++) {
			cars.add(new CarModel());
		}
	}

	public int getRemainingRounds() {
		return remainingRounds;
	}

	public List<CarModel> getCars() {
		return cars;
	}

	public void reduceRound() {
		remainingRounds--;
	}

}
