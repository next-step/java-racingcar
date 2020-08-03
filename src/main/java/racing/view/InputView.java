package racing.view;

import racing.message.ViewMsg;

import java.util.Scanner;

public class InputView {
    final int car;
    final int repeat;

    public InputView() {
        System.out.println(ViewMsg.START_MSG_CAR.getMsg());
        this.car = inputNumber();
        System.out.println(ViewMsg.START_MSG_REPEAT.getMsg());
        this.repeat = inputNumber();
    }

    private int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int getCar() {
        return car;
    }

    public int getRepeat() {
        return repeat;
    }
}
