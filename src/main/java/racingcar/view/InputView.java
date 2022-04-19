package racingcar.view;

import racingcar.dto.InputCar;
import racingcar.dto.InputRoundCount;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_INPUT_CAR_COUNT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)";
    private static final String MESSAGE_INPUT_ROUND_COUNT = "시도할 횟수는 몇 회 인가요?";
    private static final String BLANK_LINE = "";
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
        System.out.println(BLANK_LINE);
    }
}
