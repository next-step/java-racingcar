package step5.view;

import java.util.List;
import step5.model.CarRacingGame;

public class GameOutput {

    public static void printCarPaths(CarRacingGame carRacingGame) {
        printCars(carRacingGame.getCars());
    }

    private static void printCars(List<CarDTO> cars) {
        for (CarDTO car : cars) {
            printCar(car);
        }
    }

    private static void printCar(CarDTO car) {
        System.out.print(car.getCarName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public static void printWinners(List<CarDTO> winners) {
        for (CarDTO winner : winners) {
            System.out.print(winner.getCarName() + " ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}