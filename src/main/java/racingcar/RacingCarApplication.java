package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

public class RacingCarApplication {
    public static void main(String[] args) {
        String names = ConsoleInput.inputNames();
        int count = ConsoleInput.inputCount();

        ConsoleOutput.printResultHeader();

        MoveStrategy strategy = new RandomMoveStrategy();
        Cars cars = new Cars(names);
        for (int i = 0; i < count; i++) {
            cars.move(strategy);
            ConsoleOutput.printCurrentStatus(cars.getCars());
        }

        ConsoleOutput.printWinners(cars.winners());
    }
}
