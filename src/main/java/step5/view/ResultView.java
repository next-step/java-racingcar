package step5.view;

import step5.domain.Car;

public class ResultView {

    public static final String RESULT_TEXT = "실행 결과";
    public static final String FORWARD_TEXT = "-";
    public static final String END_TEXT = "";
    public static final String NAME_SEPARATOR = " : ";

    public static void printResult(Car car) {
        System.out.println(car.name + NAME_SEPARATOR + FORWARD_TEXT.repeat(car.location));
    }

    public static void start() {
        System.out.println(RESULT_TEXT);
    }

    public static void cycleEnd() {
        System.out.println(END_TEXT);
    }

    public static void printWinner(String winner) {
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}

