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
        String names = ConsoleInput.readNames();
        int count = ConsoleInput.readCount();

        MoveStrategy strategy = new RandomMoveStrategy();
        Cars cars = new Cars(names);
        race(cars, count, strategy);

        ConsoleOutput.printWinners(cars.winners());
    }

    private static void race(Cars cars, int count, MoveStrategy strategy) {
        ConsoleOutput.printResultHeader();
        for (int i = 0; i < count; i++) {
            cars.move(strategy);
            ConsoleOutput.printCurrentStatus(cars.getCars());
        }
    }
}
