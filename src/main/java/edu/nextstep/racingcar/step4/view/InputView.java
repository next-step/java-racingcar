package edu.nextstep.racingcar.step4.view;

import edu.nextstep.racingcar.step4.vo.InputInfo;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_NAMES_OF_CARS = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 를 기준으로 구분)";
    private static final String QUESTION_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";
    private final InputInfo inputInfo;

    public InputView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_NAMES_OF_CARS);
        String namesOfCars = scanner.nextLine();

        System.out.println(QUESTION_NUMBER_OF_ATTEMPTS);
        int numberOfAttempts = scanner.nextInt();

        this.inputInfo = new InputInfo(namesOfCars, numberOfAttempts);
    }

    public InputInfo getInputInfo() {
        return inputInfo;
    }
}
