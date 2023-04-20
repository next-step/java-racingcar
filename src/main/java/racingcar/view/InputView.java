package racingcar.view;

import racingcar.dto.UserInput;

import java.util.Scanner;

public class InputView {

    public static final String CAR_PARTICIPATION_NUMBER_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String CAR_REPETITION_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static UserInput getUserInput() {

        System.out.println(CAR_PARTICIPATION_NUMBER_INPUT_MESSAGE);
        int participationNumber = SCANNER.nextInt();

        System.out.println(CAR_REPETITION_COUNT_INPUT_MESSAGE);
        int repetitionCount = SCANNER.nextInt();

        return new UserInput(participationNumber, repetitionCount);
    }
}
