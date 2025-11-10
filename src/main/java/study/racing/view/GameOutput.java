package study.racing.view;

import study.racing.domain.Car;

import java.util.List;

public class GameOutput {

    public void printResult() {
        System.out.println("실행 결과");

    }

    public void printRound(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
    }

    private void printCar(Car car) {
        System.out.print(car.getName() + " : ");
        printPosition(car.getPosition());
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printEmptyLine() {
        System.out.println("");
    }
}
