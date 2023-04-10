package racingcar;

import racingcar.strategy.DefaultRandomStrategy;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameController {
    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int numberOfTries = InputView.getNumberOfTries();

        List<RacingCar> racingCars = new ArrayList<>();
        MoveStrategy moveStrategy = new RandomMoveStrategy(new DefaultRandomStrategy(), 4);
        for (int i = 0; i < numberOfCars; i++) {
            racingCars.add(new RacingCar(moveStrategy));
        }

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTries; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.goOrStop();
                OutputView.printPosition(racingCar);
            }
            System.out.println();
        }
    }
}
