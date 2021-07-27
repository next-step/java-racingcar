package racingCar.view;

import racingCar.model.Car;
import racingCar.model.Cars;

public class ResultView {
    private ResultView() {
    }

    public static void printCars(Cars cars) {
        System.out.println("\n실행결과");
        cars.play();
    }

    public static void printLocation(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
    }
}
