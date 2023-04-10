package racingcar;

import racingcar.strategy.PrintStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final List<RacingCar> racingCars;
    private final PrintStrategy printStrategy;

    public RacingCarGame(
        List<RacingCar> racingCars,
        PrintStrategy printStrategy
    ) {
        this.racingCars = racingCars;
        this.printStrategy = printStrategy;
    }

    public void play() {
        for (RacingCar racingCar : racingCars) {
            racingCar.goOrStop();
        }
    }

    public void printPosition() {
        printStrategy.print(racingCars);
    }

    public void printWinners() {
        List<RacingCar> winners = getWinners();
        for (RacingCar winner : winners) {
            System.out.print(winner.getName());
            if (winners.indexOf(winner) != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private List<RacingCar> getWinners() {
        RacingCar maxPositionRacingCar = racingCars.get(0);
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.compareTo(maxPositionRacingCar) == 1) {
                maxPositionRacingCar = racingCar;
                winners.clear();
                winners.add(racingCar);
            } else if (racingCar.compareTo(maxPositionRacingCar) == 0) {
                winners.add(racingCar);
            }
        }
        return winners;
    }
}
