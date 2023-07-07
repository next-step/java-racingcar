package racingcar.car;

import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;
import racingcar.car.domain.winnerstrategy.MaxPositionDuplicateWinnerStrategy;
import racingcar.car.domain.winnerstrategy.WinnerStrategy;
import racingcar.car.ui.ConsoleInput;
import racingcar.car.ui.ConsoleOutput;

/**
 * 자동차 경주 게임 프로그램
 */
public class CarRacingGame {

    private final Cars cars;
    private final WinnerStrategy winnerStrategy = new MaxPositionDuplicateWinnerStrategy();
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ConsoleOutput consoleOutput = new ConsoleOutput();


    public CarRacingGame() {
        cars = new Cars(consoleInput.getCarNames());
    }

    public void play() {
        startRace(consoleInput.getPlayCount());
        printWinners();
    }

    /**
     * 자동차 경주를 진행한다.
     *
     * @param count 게임 플레이 횟수
     */
    private void startRace(final int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            cars.move();
            sb.append(consoleOutput.formatCars(cars.getCars()));
        }
        consoleOutput.printResult(sb.toString());
    }

    /**
     * 자동차 경주 게임의 우승자를 출력한다.
     */
    private void printWinners() {
        List<Car> winners = cars.getWinners(winnerStrategy);
        consoleOutput.printWinners(winners);
    }
}
