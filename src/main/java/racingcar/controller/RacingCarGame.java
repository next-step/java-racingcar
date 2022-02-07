package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.MoveStrategy;
import racingcar.domain.RandomGenerate;
import racingcar.view.Console;
import racingcar.view.PrintResult;
import racingcar.domain.RacingCar;

public class RacingCarGame {

    private static final int TRY_COUNT_ZERO = 0;
    private static final MoveStrategy moveStrategy = RandomGenerate::makeRandom;
    private int tryCount;
    private List<RacingCar> cars;
    private List<RacingCar> winners;

    public void setRacingCarGame() {
        cars = RacingCar.setRacingCars(Console.setRacingCarNames());
        tryCount = Console.setTryCount();
    }

    public void playRacingCarGame() {
        setRacingCarGame();

        do {
            moveRacingCar();
            PrintResult.printMoveState(cars);
            tryCount--;

        } while (tryCount > TRY_COUNT_ZERO);

        setRacingWinners();

        PrintResult.printGameResult(winners);
    }

    private void moveRacingCar() {
        cars.forEach(car -> car.moveCar(moveStrategy));
    }

    private void setRacingWinners() {
        int maxMove = cars.stream()
            .mapToInt(RacingCar::getCarDist)
            .max()
            .orElse(0);

        winners = cars.stream()
            .filter(car -> car.getCarDist() == maxMove)
            .collect(Collectors.toList());
    }
}
