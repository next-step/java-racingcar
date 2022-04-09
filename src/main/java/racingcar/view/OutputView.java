package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OutputView {
    public void outputMoveCar(int carCount, int carMoveCount) {
        List<Car> cars = createCars(carCount);

        for (int i = 0; i < carMoveCount; i++) {
            outputMove(cars);
            outputEmptyLine();
        }
    }

    private List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    private void outputMove(List<Car> cars) {
        cars.forEach(car -> {
            car.move(getRandomNumber());
            outputPosition(car);
        });
    }

    private int getRandomNumber() {
        return new Random().nextInt(10);
    }

    private void outputPosition(Car car) {
        int position = car.getPosition();
        for (int j = 0; j < position; j++) {
            System.out.print("-");
        }

        outputEmptyLine();
    }

    private void outputEmptyLine() {
        System.out.println();
    }
}
