package me.namuhuchutong.step4.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import me.namuhuchutong.step4.dto.UserRequest;

public class InputView {

    private static final String INPUT_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String HOW_MANY_TIMES = "시도할 횟수는 몇 회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public UserRequest showPrompt() {
        return new UserRequest(showInputStringPrompt(), showInputIntegerPrompt());
    }

    private String showInputStringPrompt() {
        printMessageThroughStandardOut(INPUT_NAMES);
        return scanner.nextLine();
    }

    private int showInputIntegerPrompt() {
        printMessageThroughStandardOut(HOW_MANY_TIMES);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private void printMessageThroughStandardOut(String message) {
        System.out.println(message);
    }
}
