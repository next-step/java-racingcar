package racingcar.views;

import racingcar.domains.RacingCar;

public class ResultView {

    private ResultView() { }

    public static void printEachCarMovePath(RacingCar car) {
        System.out.println(car.getMovePath());
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printResultStrTitle() {
        System.out.println("실행결과");
    }

}
