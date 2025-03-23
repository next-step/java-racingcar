package edu.nextstep.camp.carracing.view;

import edu.nextstep.camp.carracing.domain.Cars;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";

    private ResultView() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static void printResultMessage() {
        System.out.println(System.lineSeparator() + RESULT_MESSAGE);
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public static void printCarsStatus(Cars cars) {
        System.out.println(cars.printCarsStatus());
    }
}
