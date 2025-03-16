package edu.nextstep.camp.carracing;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_HOW_MANY_TRIES = "시도할 회수는 몇 회 인가요?";

    private InputView() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static String inputCarNames(Scanner scanner) {
        System.out.println(MESSAGE_INPUT_CAR_NAMES);
        return scanner.nextLine();
    }

    public static int getTryCount(Scanner scanner) {
        System.out.println(QUESTION_HOW_MANY_TRIES);
        return scanner.nextInt();
    }
}
