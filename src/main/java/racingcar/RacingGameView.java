package racingcar;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class RacingGameView {

    private static final String SEPARATOR_WINNER_NAMES = ", ";

    private RacingGame racingGame;

    public RacingGameView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void viewCarPositions() {
        List<Car> currentCars = this.racingGame.getCurrentCars();
        for (int i = 0; i < currentCars.size(); i++) {
            printCarPosition(currentCars.get(i));
        }
        System.out.println();
    }

    public void viewWinners(List<Car> winners) {
        String names = winners.stream()
                .map(Car::getName)
                .collect(joining(SEPARATOR_WINNER_NAMES));
        System.out.println(names + " 가 최종 우승했습니다.");
    }

    private void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
