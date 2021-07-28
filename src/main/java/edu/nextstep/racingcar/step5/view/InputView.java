package edu.nextstep.racingcar.step5.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_NAMES_OF_CARS = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 를 기준으로 구분)";
    private static final String QUESTION_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public String getNamesOfCars() {
        System.out.println(QUESTION_NAMES_OF_CARS);
        return scanner.nextLine();
    }

    public int getNumberOfAttempts() {
        System.out.println(QUESTION_NUMBER_OF_ATTEMPTS);
        return scanner.nextInt();
    }
}
