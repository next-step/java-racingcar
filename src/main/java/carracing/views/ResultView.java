package carracing.views;

import carracing.domain.Car;
import carracing.domain.RacingGame;

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
}
