package racingCar.view;

import racingCar.model.Car;
import racingCar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String SEPARATOR = ", ";
    private static final String NAME_DELIMITER = " : ";
    private static final String CAR_MARKING = "-";
    private static final String RACING_GAME_MESSAGE_WINNER = "가 최종 우승했습니다.";
    private static final String RACING_GAME_MESSAGE_RESULT = "\n실행결과";

    private ResultView() {
    }

    public static void printCarsLocation(Cars cars) {
        System.out.println(RACING_GAME_MESSAGE_RESULT);
        play(cars);
        printWinner(cars);
    }

    public static void play(Cars cars) {
        for (int i = 0; i < cars.getPlayCount(); i++) {
            printCarsLocation(cars.moveCars());
        }
    }

    public static void printCarsLocation(List<Car> cars) {
        for (Car car : cars) {
            printLocation(car);
        }
        System.out.println();
    }

    public static void printLocation(Car car) {
        System.out.print(car.getName() + NAME_DELIMITER);
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(CAR_MARKING);
        }
        System.out.println();
    }

    public static void printWinner(Cars cars) {
        String winners = cars.findWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(SEPARATOR));
        System.out.println(winners + RACING_GAME_MESSAGE_WINNER);
    }
}
