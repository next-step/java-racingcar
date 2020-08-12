package racing;

import racing.message.ViewMessage;

import java.util.Scanner;

public class InputView {
    private int carNumber;
    private int tryCount;

    public InputView() {
        System.out.println(ViewMessage.START_MESSAGE_CAR_NUMBER.getMessage());
        this.carNumber = InputValue();
        System.out.println(ViewMessage.START_MESSAGE_TRY_COUNT.getMessage());
        this.tryCount = InputValue();
    }

    public int InputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getTryCount() {
        return tryCount;
    }
}
