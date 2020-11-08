package racingcar.view;

import racingcar.domain.Car;

public class ResultView {

    public void printDistanceOfCar(Car[] cars) {
        for (Car car : cars) {
            print(car.getDistance());
            System.out.println("");
        }
    }

    public void print(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
    }


}
