package com.java.jaeheon.step2.view;

import java.util.List;
import java.util.StringJoiner;

import com.java.jaeheon.step2.RacingGame;
import com.java.jaeheon.step2.domain.Car;

public class ResultView {
    private static final String POSITION_SYMBOL = "-";

    public static void resultViewRacing(RacingGame racingGame) {
        changeNextLine();
        System.out.println("실행 결과");
        for (int attempts = 1; attempts <= racingGame.getNumberOfAttempts(); attempts++) {
            resultViewByCars(racingGame.getCars(attempts));
        }
        resultViewByWinners(racingGame.getWinner());
    }

    private static void resultViewByCars(List<Car> cars) {
        for (Car car : cars) {
            resultViewPositionByCar(car);
            changeNextLine();
        }
        changeNextLine();
    }

    private static void resultViewPositionByCar(Car car) {
        System.out.print(car.getNameOfCar() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_SYMBOL);
        }
    }

    private static void resultViewByWinners(List<Car> winners) {
        StringJoiner joiner = new StringJoiner(",");
        for (Car car : winners) {
            joiner.add(car.getNameOfCar());
        }
        System.out.println(joiner.toString() + " 가 최종 우승했습니다.");
    }

    private static void changeNextLine() {
        System.out.println();
    }

}
