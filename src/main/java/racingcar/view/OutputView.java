package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    public void printResult(Car car) {
        String result = "";
        for (int i = 0; i < car.getMovement(); i++) {
            result += "-";
        }
        System.out.println(result);
    }
}
