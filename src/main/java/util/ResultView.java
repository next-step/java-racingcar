package util;

import racingcar.Car;

import java.util.List;

public class ResultView {
    public static void showResultMessage(){
        System.out.println("실행 결과");
    }

    private static void showCarResult(List<Car> cars){
        for(Car car: cars) {
            System.out.println("-".repeat(car.getDistance()));
        }
    }

    private static void showEndOfTry() {
        System.out.println();
    }

    public static void showCarGameResult(List<Car> cars){
        showCarResult(cars);
        showEndOfTry();
    }
}
