package racing.view;

import racing.message.ViewMsg;
import racing.util.ValidatorUtils;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private final String[] arrName;
    private final int repeatCount;

    public InputView() throws Exception {
        System.out.println(ViewMsg.START_MSG_CAR.getMsg());
        arrName = inputString().split(",");
        checkName();
        System.out.println(ViewMsg.START_MSG_REPEAT.getMsg());
        this.repeatCount = inputNumber();
    }

    private String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String[] getCarNames() {
        return arrName;
    }

    public int getrepeatCount() {
        return repeatCount;
    }

    private void checkName() throws Exception {
        Arrays.stream(this.arrName).forEach(name -> {
            ValidatorUtils.name(name);
        });
    }
}
