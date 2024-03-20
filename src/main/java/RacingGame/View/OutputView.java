package RacingGame.View;

import RacingGame.Domain.Car;

import java.util.List;
import java.util.Scanner;

public class OutputView {
    public void OutputView() {
        System.out.println("Result");
    }

    public void PrintResult(List<Car> carList) {
        printAllCars(carList);
    }

    private void printAllCars(List<Car> carList) {
        for (Car car : carList) {
            printCarStatus(car);
        }
    }

    private void printCarStatus(Car car) {
        int count = car.GetMoveInfo();
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
