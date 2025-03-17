package racingcar;

import java.util.List;

public class ResultView {

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}