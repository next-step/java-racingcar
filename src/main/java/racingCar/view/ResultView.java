package racingCar.view;

import racingCar.model.Car;
import racingCar.model.Cars;
import racingCar.utils.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String SEPARATOR = ", ";

    private ResultView() {
    }

    public static void printCars(Cars cars) {
        System.out.println("\n실행결과");
        play(cars);
        printWinner(cars);
    }

    public static void play(Cars cars) {
        for (int i = 0; i < cars.getPlayCount(); i++) {
            moveCars(cars.getCars());
        }
    }

    public static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomUtil.getNumber());
            printLocation(car);
        }
        System.out.println();
    }

    public static void printLocation(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(Cars cars) {
        String winners = cars.findWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(SEPARATOR));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
