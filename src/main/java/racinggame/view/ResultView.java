package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.MovingStrategy;
import racinggame.domain.Position;
import racinggame.domain.RacingGame;

import java.util.List;

public class ResultView {
    private static final String PROGRASS_BAR = "-";
    public static final String RESULT_MESSAGE = "실행 결과";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printResul(RacingGame racingGame, MovingStrategy movingStrategy) {
        while (racingGame.getTryCount() > 0) {
            racingGame.start(movingStrategy);
            printRacingProgress(racingGame.getCars());
        }
    }

    public void printRacingProgress(List<Car> cars) {
        for (Car car : cars) {
            Position position = car.getPosition();
            System.out.println(PROGRASS_BAR.repeat(position.getPosition()));
        }
        System.out.println();
    }
}
