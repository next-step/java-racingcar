package racing.view;

import racing.message.ViewMessage;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static void carNamesInputView() {
        System.out.println(ViewMessage.START_MESSAGE_INPUT_CAR_NAMES.getMessage());
    }

    public static void tryCountInputView() {
        System.out.println(ViewMessage.START_MESSAGE_INPUT_TRY_COUNT.getMessage());
    }

    public static int inputValue() {
        return scanner.nextInt();
    }

    public static String inputCarNames() {
        return scanner.nextLine();
    }



}