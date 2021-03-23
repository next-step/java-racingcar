package ch01.racinggame.view;

import ch01.racinggame.Domain.Car;
import ch01.racinggame.Domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class ResultView {


    public ResultView() {
        System.out.println("실행결과");
    }


    public ResultView(Car[] cars) {

        showResult(cars);
    }

    public void showResult(Car[] cars) {
        this.print(cars);
    }

    public void showWinnerResult(List<Car> carList) {
        showWinners(carList);
    }

    private void print(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            nullAndEmpty(cars[i]);
        }
        System.out.println();
    }

    private void nullAndEmpty(Car car) {
        if (car != null) {
            System.out.println(car.name() + ":" + car.toString());
        }
    }

    private void showWinners(List<Car> winners) {
        StringBuilder out = new StringBuilder();
        String result;

        for (Car car : winners) {
            out.append(car.name() + ", ");
        }

        result = out.substring(0, out.lastIndexOf(","));
        System.out.println(result + "가 최종 우승했습니다.");
    }


}
