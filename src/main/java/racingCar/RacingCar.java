package racingCar;

import racingCar.domain.Car;
import racingCar.domain.Track;

public class RacingCar {
	private int round;

	private int count;

	private final Track track;

	public RacingCar() {
		track = Track.create();
	}

	public void start() {
		ready();

		run(count, round);

		terminate();
	}

	public void run(int count, int round) {
		for (int i = 0; i < count; i++) {
			track.putRaceCar(Car.create());
		}

		track.run(round);
	}

	private void ready() {
		count = RacingCarUI.uiForCountInput();

		round = RacingCarUI.uiForRoundInput();
	}

	private void terminate() {
		RacingCarUI.printResult(track.getCarList());
	}
}
