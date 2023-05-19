package study.step3;

import study.step3.domain.Car;

import java.util.List;

public class ResultView {

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getPositionStr());
        }
        System.out.println();

    }

}
