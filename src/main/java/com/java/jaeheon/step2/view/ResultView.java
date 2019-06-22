package com.java.jaeheon.step2.view;

import java.util.List;

import com.java.jaeheon.step2.model.Car;
import com.java.jaeheon.step2.model.RecordBoard;

public class ResultView {
    private static final String POSITION_SYMBOL = "-";

    public static void resultViewRacing(RecordBoard recordBoard) {
        changeNextLine();
        System.out.println("실행 결과");
        for (int attempts = 1; attempts <= recordBoard.getRecordedNumber(); attempts++) {
            List<Car> cars = recordBoard.getRecord(attempts);
            resultViewByCar(cars);
        }
        System.out.println(recordBoard.getWinner() + "가 최종 우승했습니다.");
    }

    public static void resultViewByCar(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getNameOfCar() + " : ");
            resultViewPositionByCar(car);
            changeNextLine();
        }
        changeNextLine();
    }

    public static void resultViewPositionByCar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_SYMBOL);
        }
    }

    public static void changeNextLine() {
        System.out.println();
    }

}
