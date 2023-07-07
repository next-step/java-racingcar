package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

public class RacingCarApplication {
    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("[ERROR] 예상하지 못한 예외가 발생했습니다. 프로그램을 종료합니다.");
        }
    }

    private static void run() {
        final String names = ConsoleInput.readNames();
        final int count = ConsoleInput.readCount();

        final MoveStrategy strategy = new RandomMoveStrategy();
        final Cars cars = new Cars(names);

        if (!cars.canStartRace()) {
            throw new IllegalArgumentException("[ERROR] 최소 2대 이상의 자동차가 있어야 합니다.");
        }
        race(cars, count, strategy);

        ConsoleOutput.printWinners(cars.winners());
    }

    private static void race(final Cars cars, final int totalCount, final MoveStrategy strategy) {
        ConsoleOutput.printResultHeader();
        for (int count = 0; count < totalCount; count++) {
            cars.move(strategy);
            ConsoleOutput.printCurrentStatus(cars.getCars());
        }
    }
}
