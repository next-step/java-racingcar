package study.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingContest {
	private List<Car> cars;
	private final int tryNo;
	private final Random random = new Random();
	private int currentTry;

	public RacingContest(int racingParticipantNo, int tryNo) {
		cars = new ArrayList<>();
		for (int i = 0; i < racingParticipantNo; i++) {
			this.cars.add(new Car());
		}
		this.tryNo = tryNo;
	}

	public void start() {
		currentTry = 0;
	}

	public RacingResult gerResult() {
		RacingResult racingResult = new RacingResult();

		cars.forEach(car -> {
			racingResult.addResult(car.getPosition());
		});

		return racingResult;
	}

	public boolean isPlaying() {
		return currentTry < tryNo;
	}

	public void play() {
		cars.forEach(car -> {
			car.fillUpFuel(random.nextInt() % 10);
			car.pushGasPedal();
		});
		currentTry++;
	}
}
