package racingcar;

import java.util.List;

public class RacingCarGame {
	private ParticipatingCars participatingCars;
	private RoundCount roundCount;

	public RacingCarGame(String carNames, int roundCount) {
		this.participatingCars = new ParticipatingCars(carNames);
		this.roundCount = new RoundCount(roundCount);
	}

	public String[] getParticipatingCarNames() {
		List<RacingCar> cars = participatingCars.get();
		int carCount = cars.size();

		String[] carNames = new String[carCount];
		for (int i = 0; i < carCount; i++) {
			carNames[i] = cars.get(i).getName();
		}

		return carNames;
	}
}
