package carRacing.view;

import carRacing.model.Car;

import java.util.List;

public class OutputView {
    public void printRacingResultExcutedCycle(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void printRacingWinner(String winners) {
        System.out.printf("%s 가 최종 우승했습니다.%n",winners);
    }
}
