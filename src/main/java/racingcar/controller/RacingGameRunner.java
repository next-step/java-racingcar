package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.DefaultRandomPicker;
import racingcar.view.CarStatus;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameRunner {

    public static void main(String[] args) {
        InputView input = InputView.input();
        List<Car> cars = initCar(input.carCount());

        System.out.println("\n실행 결과");
        for (int idx = 0; idx < input.moveCount(); idx++) {
            game(cars);
            printResult(cars);
        }
    }

    private static List<Car> initCar(int carCount) {
        List<Car> cars = new ArrayList<>(carCount);

        for (int idx = 0; idx < carCount; idx++) {
            cars.add(Car.create("car", new DefaultRandomPicker()));
        }

        return cars;
    }

    private static void game(List<Car> cars) {
        for (Car car: cars) {
            car.game();
        }
    }

    private static void printResult(List<Car> cars) {
        List<CarStatus> carStatuses = new ArrayList<>(cars.size());

        for (Car car: cars) {
            carStatuses.add(new CarStatus(car.grade()));
        }

        ResultView.result(carStatuses)
                .print();
    }
}
