package racingCar;

import java.util.List;

import racingCar.domain.Car;
import racingCar.domain.Track;

public class RacingCar {
	private int round;

	private List<String> carNames;

	private final Track track;

	public RacingCar() {
		track = Track.create();
	}

	public void start() {
		ready();

		run(carNames, round);

		terminate();
	}

	public void run(List<String> carNames, int round) {
		for (String carName : carNames) {
			track.putRaceCar(Car.from(carName));
		}

		track.run(round);
	}

	private void ready() {
		round = RacingCarUI.uiForRoundInput();

		carNames = RacingCarUI.uiForCarNamesInput();
	}

	private void terminate() {
		RacingCarUI.printResult(track.getCarList(), track.findWinners());
	}
}
