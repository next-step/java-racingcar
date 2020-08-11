package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {
    private final String MOVEMENT = "-";

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printResult(List<Car> cars) {
        for(Car car: cars) {
            for(int i = 0; i< car.getPosition(); i++)
                System.out.print(MOVEMENT);
            System.out.println();
        }
    }
}
