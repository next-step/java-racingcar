package racingcar.view;

import racingcar.domain.InputCarCount;
import racingcar.domain.InputRoundCount;

import java.util.Scanner;

public class InputView {

    public static final String MESSAGE_INPUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    public static final String MESSAGE_INPUT_ROUND_COUNT = "시도할 횟수는 몇 회 인가요?";

    public static InputCarCount viewInputCarCount() {
        InputCarCount carCount = null;
        try {
            System.out.println(MESSAGE_INPUT_CAR_COUNT);
            Scanner scanner = new Scanner(System.in);
            carCount = new InputCarCount(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            return viewInputCarCount();
        }
        return carCount;
    }

    public static InputRoundCount viewInputRoundCount() {
        InputRoundCount roundCount = null;
        try {
            System.out.println(MESSAGE_INPUT_ROUND_COUNT);
            Scanner scanner = new Scanner(System.in);
            roundCount = new InputRoundCount(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            return viewInputRoundCount();
        }
        return roundCount;
    }
}
