package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.RacingGame;

public class OutputView {

	public static void printRoundResult(RacingGame racingGame) {
		for (String result : racingGame.play()) {
			System.out.println(result);
		}
	}

	public static void printResults(int count, RacingGame racingGame) {
		System.out.println("실행 결과");

		for (int i = 0; i < count; i++) {
			printRoundResult(racingGame);
			System.out.println();
		}
	}

    public static void printWinners(RacingGame racingGame) {
        System.out.println(String.join(", ", racingGame.findWinners()) + "가 최종 우승했습니다.");
    }

	public static String getPositionDisplay(Car car) {
        if (car.getName().isEmpty()) {
            return "-".repeat(car.getPosition());
        }

        return car.getName() + " : " + "-".repeat(car.getPosition());
	}
}
