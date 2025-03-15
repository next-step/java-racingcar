package edu.nextstep.camp.racingcar.step3;

import java.util.Scanner;

public class InputView {
    private static final String QUESTION_HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_HOW_MANY_TRIES = "시도할 회수는 몇 회 인가요?";

    private InputView() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static int getCarCount(Scanner scanner) {
        System.out.println(QUESTION_HOW_MANY_CARS);
        return scanner.nextInt();
    }

    public static int getTryCount(Scanner scanner) {
        System.out.println(QUESTION_HOW_MANY_TRIES);
        return scanner.nextInt();
    }
}
