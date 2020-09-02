package racing;

import racing.message.ViewMessage;

import java.util.Scanner;

public class InputView {

    public void carNumberInputView() {
        System.out.println(ViewMessage.START_MESSAGE_CAR_NUMBER.getMessage());
    }

    public void tryCountInputView() {
        System.out.println(ViewMessage.START_MESSAGE_TRY_COUNT.getMessage());
    }

    public int inputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}