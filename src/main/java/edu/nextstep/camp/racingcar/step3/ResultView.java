package edu.nextstep.camp.racingcar.step3;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";

    private ResultView() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getPositionString());
        }
        System.out.println();
    }
}
