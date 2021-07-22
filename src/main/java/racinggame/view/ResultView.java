package racinggame.view;

import racinggame.car.Car;
import racinggame.car.Cars;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";

    private final Cars cars;
    private final int count;

    public ResultView(Cars cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < count; i++) {
            gameStatus(i);
            System.out.println();
        }
        printWinner();
    }

    private void gameStatus(int i) {
        for (Car car : cars.getCars()) {
            car.print(i);
        }
    }

    private void printWinner() {
        System.out.println(cars.getWinner() + "가 최종 우승했습니다.");
    }
}
