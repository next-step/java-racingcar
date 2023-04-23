package racingcar.view;

import racingcar.dto.UserInput;

import java.util.Scanner;

public class InputView {
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String CAR_REPETITION_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static UserInput getUserInput() {

        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carName = SCANNER.next();

        System.out.println(CAR_REPETITION_COUNT_INPUT_MESSAGE);
        int repetitionCount = SCANNER.nextInt();

        return new UserInput(repetitionCount, carName);
    }
}
