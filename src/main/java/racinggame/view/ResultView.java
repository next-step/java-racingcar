package racinggame.view;

import racinggame.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PROGRASS_BAR = "-";
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String SEPARATOR = " : ";
    public static final String WINNER_PRINT_MESSAGE = " (이)가 최종 우승했습니다.";
    public static final String DELIMITER_COMMA = ", ";

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

    public void printWinner(RacingGame racingGame) {
        String winner = racingGame.resultWinnerNames()
                .stream()
                .map(Name::getName)
                .collect(Collectors.joining(DELIMITER_COMMA));
        System.out.println(winner + WINNER_PRINT_MESSAGE);
    }
}
