package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public void printDistanceOfCar(List<Car> cars) {

        for (Car car : cars) {
            print(car.getName(), car.getDistance());
        }
        System.out.println("");
    }

    public void printHeader() {
        System.out.println("실행 결과");
    }

    public void print(String nameOfCar, int distance) {
        System.out.print(nameOfCar + " : ");
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }


}
