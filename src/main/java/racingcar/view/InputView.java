package racingcar.view;

import racingcar.dto.InputCar;
import racingcar.dto.InputRoundCount;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_INPUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_INPUT_ROUND_COUNT = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() { }

    public static InputCar renderCarCountInputView() {
        try {
            System.out.println(MESSAGE_INPUT_CAR_COUNT);
            return new InputCar(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            renderErrorMessage(e.getMessage());
            return renderCarCountInputView();
        }
    }

    public static InputRoundCount renderRoundCountInputView() {
        try {
            System.out.println(MESSAGE_INPUT_ROUND_COUNT);
            return new InputRoundCount(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            renderErrorMessage(e.getMessage());
            return renderRoundCountInputView();
        }
    }

    private static void renderErrorMessage(String message) {
        System.out.println(message);
        System.out.println("");
    }
}
