package racingcar.controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import racingcar.view.Console;
import racingcar.view.PrintResult;
import racingcar.domain.RacingCar;

public class RacingCarGame {

    private int tryCount;
    private List<RacingCar> cars;
    private List<RacingCar> winners;

    private static final int MIN_MOVE = 0;
    private static final int MAX_MOVE = 9;
    private static final int NUMBER_ZERO = 0;

    private static final Random random = new Random();
    private static final Console console = new Console();

    public void setRacingCarGame() {
        cars = RacingCar.setRacingCars(console.setRacingCarNames());
        tryCount = console.setTryCount();
    }

    public void playRacingCarGame() {
        setRacingCarGame();

        do {
            moveRacingCar();
            PrintResult.printMoveState(cars);
            tryCount--;

        } while (tryCount > NUMBER_ZERO);

        setRacingWinners();

        PrintResult.printGameResult(winners);
    }

    private void moveRacingCar() {
        cars.forEach(car -> car.moveCar(randomMove()));
    }

    private int randomMove() {
        return MIN_MOVE + random.nextInt(MAX_MOVE - MIN_MOVE + 1);
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
