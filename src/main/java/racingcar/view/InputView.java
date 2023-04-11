package racingcar.view;

import racingcar.domain.InputData;

import java.util.Scanner;

public class InputView {

    public static final String CAR_PARTICIPATION_NUMBER_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String CAR_REPETITION_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 대 인가요?";

    public InputData getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(CAR_PARTICIPATION_NUMBER_INPUT_MESSAGE);
        int participationNumber = scanner.nextInt();

        System.out.println(CAR_REPETITION_COUNT_INPUT_MESSAGE);
        int repetitionCount = scanner.nextInt();

        return new InputData(participationNumber, repetitionCount);
    }
}
