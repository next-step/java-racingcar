package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class RacingGameView {

    private static final String SEPARATOR_WINNER_NAMES = ", ";

    private RacingGame racingGame;

    public RacingGameView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }


    public void viewResult(List<Cars> carLogs) {
        for (Cars cars : carLogs) {
            printCarPositions(cars);
        }
    }

    public void printCarPositions(Cars cars) {
        for (Car car : cars.getCarsToList()) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void viewWinners(Cars cars) {
        String names = cars.getWinners().stream()
                .map(Car::getName)
                .collect(joining(SEPARATOR_WINNER_NAMES));
        System.out.println(names + " 가 최종 우승했습니다.");
    }
}
