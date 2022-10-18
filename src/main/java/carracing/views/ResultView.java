package carracing.views;

import carracing.domain.Car;
import carracing.domain.RacingGame;

import java.util.List;

public class ResultView {
    public void showRacingPosition(RacingGame racingGame) {
        for (Car car : racingGame.getCarList()) {
            System.out.println(car.makePositionToDash());
        }
        System.out.println();
    }
}
