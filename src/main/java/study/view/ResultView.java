package study.view;

import study.car.Car;

import java.util.List;

public class ResultView {

    private ResultView() { //인스턴스화 방지
    }

    public static void beforeRacingPrintMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printOneRacingResult(List<Car> raceList) {
        for (Car car : raceList) {
            System.out.println(car.getStatus());
        }
        System.out.println("");
    }
}
