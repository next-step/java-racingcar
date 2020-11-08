package nextstep.step3;

import nextstep.step3.domain.RacingCars;
import nextstep.step3.domain.RandomGenerator;
import nextstep.step3.view.InputView;
import nextstep.step3.view.ResponseView;

import java.util.Scanner;
import java.util.stream.IntStream;

public class RacingCarGame {
	public static void main(String[] args) {
		InputView inputView = new InputView(new Scanner(System.in));
		startGame(inputView.getInputMessageCarNumber(), inputView.getInputMessageTryNumber());
	}

	protected static void startGame(int carNumber, int tryNumber) {
		RacingCars racingCars = new RacingCars(carNumber);
		tryRacing(tryNumber, racingCars);
	}

	private static void tryRacing(int tryNumber, RacingCars racingCars) {
		System.out.println("실행 결과");
		IntStream.range(0, tryNumber).forEach(i ->  {
			racingCarMove(racingCars);
			printRacingResult(racingCars);
		});
	}

	private static void racingCarMove(RacingCars racingCars) {
		RandomGenerator randomGenerator = new RandomGenerator();
		racingCars.getRacingCars().forEach( car -> {
			car.move(randomGenerator.getRandomNumber());
		});
	}

	private static void printRacingResult(RacingCars racingCars) {
		ResponseView responseView = new ResponseView();
		responseView.showRacingResult(racingCars);
	}
}
