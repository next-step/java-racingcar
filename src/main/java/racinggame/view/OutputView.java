package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.RacingGame;

public class OutputView {

    public static void printWinners(RacingGame racingGame) {
        System.out.println(racingGame.findWinners().formatWinners() + "가 최종 우승했습니다.");
    }

	public static String getPositionDisplay(Car car) {
        if (car.getName().isEmpty()) {
            return "-".repeat(car.getPosition());
        }

        return car.getName() + " : " + "-".repeat(car.getPosition());
	}
}
