package study.step_3;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        int numberOfCars = InputView.numberOfCars();
        int numberOfTrial = InputView.numberOfTrial();

        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        for (int i = 0; i < numberOfTrial; i++) {
            for (Car car : cars) {
                RandomNumber randomNumber = new RandomNumber();
                car.move(randomNumber.movable());
            }
        }

        for (Car car : cars) {
            OutputView.result(car.count());
        }
    }
}
