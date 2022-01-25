package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private int tryCount;
    private List<RacingCar> cars;
    private List<RacingCar> winners;

    public void setRacingCarGame() {
        Console console = new Console();

        cars = RacingCar.setRacingCars(console.setRacingCarNames());
        tryCount = console.setTryCount();
    }

    public void playRacingCarGame() {
        setRacingCarGame();

        do {
            controlRacingCar();
            PrintResult.printMoveState(cars);
            tryCount--;
        } while (tryCount > 0);

        setRacingWinners();

        PrintResult.printGameResult(winners);
    }

    private void controlRacingCar() {
        cars.forEach(RacingCar::moveCar);
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
