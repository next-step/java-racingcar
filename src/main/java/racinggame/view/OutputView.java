package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;


public class OutputView {
    private static int maxPosition = 0;
    static List<String> winners = new ArrayList<>();

	static void printRoundResult(RacingGame racingGame) {
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

        for (Car car : racingGame.getCars()) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
	}

    public static void printWinners(RacingGame racingGame) {
        for (Car car : racingGame.getCars()) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

	public static String getPositionDisplay(Car car) {
		return "-".repeat(car.getPosition());
	}

    public static String getPositionDisplayWithNames(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }
}
