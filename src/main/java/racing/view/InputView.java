package racing.view;

import racing.message.ViewMsg;

import java.util.Scanner;

public class InputView {
    final int carCount;
    final int repeatCount;

    public InputView() {
        System.out.println(ViewMsg.START_MSG_CAR.getMsg());
        this.carCount = inputNumber();
        System.out.println(ViewMsg.START_MSG_REPEAT.getMsg());
        this.repeatCount = inputNumber();
    }

    private int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getrepeatCount() {
        return repeatCount;
    }
}
