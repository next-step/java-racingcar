package racing;

import racing.model.RacingCar;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

	private static final int MAX_RANDOM_BOUND = 10;

	Random random = new Random();

	ResultView resultView = new ResultView();

	Scanner scanner = new Scanner(System.in);

	public void start() {
		InputView inputView = initInputView();

		List<RacingCar> racingCarList = prepareInitRacingCar(inputView.getPlayRacingCarCount());
		for (int i = 0; i < inputView.getPlayCount(); i++) {
			speedUpForPlayCount(racingCarList);
			System.out.println();
		}
	}

	private InputView initInputView() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		int playRacingCarCount = scanner.nextInt();
		System.out.println(playRacingCarCount);

		System.out.println("시도할 회수는 몇 회 인가요?");
		int playCount = scanner.nextInt();
		System.out.println(playCount);

		return new InputView(playRacingCarCount, playCount);
	}

	//todo 전략패턴
	//https://github.com/next-step/java-racingcar/pull/1623#discussion_r536464659
	private void speedUpForPlayCount(List<RacingCar> racingCarList) {
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
