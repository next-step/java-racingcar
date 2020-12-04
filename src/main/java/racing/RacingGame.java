package racing;

import racing.model.RacingCar;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

	private static final int MAX_RANDOM_BOUND = 10;

	Random random = new Random();

	public void start() {
		InputView inputView = new InputView();
		inputView.inputUI();

		List<RacingCar> racingCarList = prepareInitRacingCar(inputView.getPlayCarCount());
		for (int i = 0; i < inputView.getPlayCount(); i++) {
			speedUpForPlayCount(racingCarList);
			System.out.println();
		}
	}

	private void speedUpForPlayCount(List<RacingCar> racingCarList) {
		ResultView resultView = new ResultView();
		for (RacingCar racingCar : racingCarList) {
			racingCar.recordResult(racingCar.isForward(random.nextInt(MAX_RANDOM_BOUND)));
			resultView.print(racingCar.getForwardRecord());
		}
	}

	private List<RacingCar> prepareInitRacingCar(int playCarCount) {
		List<RacingCar> racingCarList = new ArrayList<>();
		for (int i = 0; i < playCarCount; i++) {
			racingCarList.add(new RacingCar());
		}
		return racingCarList;
	}
}
