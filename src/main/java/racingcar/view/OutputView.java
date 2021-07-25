package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String MSG_RESULT = "실행 결과";

    public void printResultMessage() {
        System.out.println(MSG_RESULT);
    }

    public void printStatusFromScores(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName()+" : ");
            for (int i = 0; i < car.getScore(); i++) {
                System.out.print("-");
            }
            System.out.println();
        });
        System.out.println();
    }
}
