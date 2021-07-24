package racingCar.view;

import racingCar.domain.Car;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";

    public void printExecutionResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printEnter() {
        System.out.println();
    }

    public void printCarDistance(Car car) {
        System.out.print(car.getCarName() + " : ");
        for(int i = 0; i < car.getCarDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
