package racingcar.view;

import racingcar.factory.CarsFactory;
import racingcar.generator.RandomNumberGenerator;
import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void outputMoveCar(int carCount, int carMoveCount) {
        List<Car> cars = CarsFactory.create(carCount);

        for (int i = 0; i < carMoveCount; i++) {
            outputMove(cars);
            outputEmptyLine();
        }
    }

    private void outputMove(List<Car> cars) {
        cars.forEach(car -> {
            car.move(new RandomNumberGenerator());
            outputPosition(car);
        });
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
