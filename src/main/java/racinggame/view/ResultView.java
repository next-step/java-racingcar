package racinggame.view;

import racinggame.domain.*;

import java.util.List;

public class ResultView {
    private static final String PROGRASS_BAR = "-";
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String SEPARATOR = " : ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printResul(RacingGame racingGame, MovingStrategy movingStrategy) {
        printRacingProgress(racingGame.getCars());
        while (racingGame.getTryCount() > 0) {
            racingGame.start(movingStrategy);
            printRacingProgress(racingGame.getCars());
        }
    }

    public void printRacingProgress(List<Car> cars) {
        for (Car car : cars) {
            Name name = car.getName();
            Position position = car.getPosition();
            System.out.println(name.getName() + SEPARATOR + PROGRASS_BAR.repeat(position.getPosition()));
        }
        System.out.println();
    }
}
