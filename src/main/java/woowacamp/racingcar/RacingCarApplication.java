package woowacamp.racingcar;

import woowacamp.racingcar.domain.Car;
import woowacamp.racingcar.domain.Cars;
import woowacamp.racingcar.domain.NumberGenerator;
import woowacamp.racingcar.domain.RandomNumberGenerator;
import woowacamp.racingcar.view.CarStatus;
import woowacamp.racingcar.view.ConsoleInput;
import woowacamp.racingcar.view.ConsoleOutput;

import java.util.List;
import java.util.stream.Collectors;

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

        Cars cars = new Cars(names);
        race(cars, count, new RandomNumberGenerator());

        List<CarStatus> winners = toStatus(cars.winners());
        ConsoleOutput.printWinners(winners);
    }

    private static void race(Cars cars, int count, NumberGenerator strategy) {
        ConsoleOutput.printResultHeader();
        for (int i = 0; i < count; i++) {
            cars.move(strategy);

            List<CarStatus> statuses = toStatus(cars.getCars());
            ConsoleOutput.printCurrentStatus(statuses);
        }
    }

    private static List<CarStatus> toStatus(List<Car> cars) {
        return cars.stream()
                .map(CarStatus::from)
                .collect(Collectors.toList());
    }
}
