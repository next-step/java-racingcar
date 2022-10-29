package carracing.views;

import carracing.domain.Car;
import carracing.domain.RacingGame;

import java.util.List;

public class ResultView {
    private static final String DASH = "-";
    private static final String COLON = " : ";

    public void showRacingPosition(RacingGame racingGame) {
        for (Car car : racingGame.getCarList()) {
            System.out.println(car.getName() + COLON + makePositionToDash(car));
        }
        System.out.println();
    }

    public static String makePositionToDash(Car car) {
        return DASH.repeat(car.getPosition());
    }

    public void showWinners(RacingGame racingGame) {
        String winnersName = String.join(",", racingGame.getWinnerList());
        System.out.println(winnersName + " 가 최종 우승했습니다.");
    }
}
