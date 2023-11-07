package racingcar.view;

import racingcar.Car;
import racingcar.RacingCarGame;

public class ResultView {

    public static final String CAR_PATH = "-";

    private RacingCarGame racingCarGame;

    public ResultView(RacingCarGame racingCarGame) {
        this.racingCarGame = racingCarGame;
    }

    public void printRace() {
        for (Car car : racingCarGame.carList()) {;
            System.out.println(createPath(car.distance()));
        }
        System.out.println();
    }

    private String createPath(int count) {
        return CAR_PATH.repeat(count);
    }
}
