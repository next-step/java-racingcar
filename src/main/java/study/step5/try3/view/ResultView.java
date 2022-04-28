package study.step5.try3.view;

import study.step5.try3.domain.Car;
import study.step5.try3.domain.Cars;

public class ResultView {
    private final Cars cars;
    private final int numberOfAttempts;

    public ResultView(Cars cars, int numberOfAttempts) {
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public static ResultView of(Cars cars, int numberOfAttempts) {
        return new ResultView(cars, numberOfAttempts);
    }

    public void printRecodeResult() {
        System.out.println("실행 결과");
        for (int round = 0; round < this.numberOfAttempts; round++) {
            startPrint(round);
        }
    }

    private void startPrint(int round) {
        for (Car car : this.cars.getCars()) {
            car.print(round);
        }
        System.out.println();
    }

    public void printWinners() {
        System.out.println(this.cars.getWinners() + "가 최종 우승했습니다.");
    }
}
