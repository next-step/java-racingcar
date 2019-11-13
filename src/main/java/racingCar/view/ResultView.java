package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.Cars;

import java.util.List;

public class ResultView {

    public static void print(List<Cars> cars) {
        for (Cars racingCar : cars) {
            printRacingCars(racingCar);
            System.out.println("-----------------------");
        }
    }

    private static void printRacingCars(Cars racingCars) {
        List<Car> cars = racingCars.getCars();
        for (Car car : cars) {
            printCar(car);
        }
    }

    private static void printCar(Car car) {
        System.out.print(car.getName() + " : ");
        printPositionBar(car.getPosition());
    }

    private static void printPositionBar(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("- ");
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        for (Car winner : winners) {
            System.out.print(winner.getName() + " ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
