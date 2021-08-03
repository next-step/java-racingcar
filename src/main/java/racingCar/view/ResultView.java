package racingCar.view;

import racingCar.model.Car;
import racingCar.model.RacingGame;
import racingCar.model.RandomMovingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String SEPARATOR = ", ";
    private static final String NAME_DELIMITER = " : ";
    private static final String CAR_MARKING = "-";
    private static final String RACING_GAME_MESSAGE_WINNER = "가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void printCarsLocation(List<Car> cars) {
        for (Car car : cars) {
            printLocation(car);
        }
        System.out.println();
    }

    private static void printLocation(Car car) {
        System.out.print(car.getName() + NAME_DELIMITER);
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(CAR_MARKING);
        }
        System.out.println();
    }

    public static void printWinner(List<Car> cars) {
        String winners = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(SEPARATOR));
        System.out.println(winners + RACING_GAME_MESSAGE_WINNER);
    }
}
