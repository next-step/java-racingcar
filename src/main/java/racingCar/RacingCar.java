package racingCar;

import java.util.Scanner;

import racingCar.domain.Car;
import racingCar.domain.Track;

public class RacingCar {
	private int round;

	private int count;

	private final Track track;

	public RacingCar() {
		track = Track.of();
	}

	public void start() {
		ready();

		run(count, round);

		terminate();
	}

	public void run(int count, int round) {
		for (int i = 0; i < count; i++) {
			track.putRaceCar(Car.of());
		}

		track.run(round);
	}

	private void ready() {
		Scanner sc = new Scanner(System.in);

		RacingCarUI.printReadyStep1();
		count = Integer.parseInt(sc.nextLine());

		RacingCarUI.printReadyStep2();
		round = Integer.parseInt(sc.nextLine());
	}

	private void terminate() {
		RacingCarUI.printResult(track.getCarList());
	}
}
