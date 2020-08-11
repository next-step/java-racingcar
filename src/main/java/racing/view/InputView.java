package racing.view;

import racing.message.ViewMsg;
import racing.util.ValidatorUtils;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final String[] carNames;
    private final int repeatCount;

    public InputView() throws Exception {
        carNames = inputCarNames();
        ValidatorUtils.validName(carNames);
        repeatCount = inputRepeatCount();
    }

    private String[] inputCarNames() {
        System.out.println(ViewMsg.START_MSG_CAR.getMsg());
        return Arrays.stream(inputString().split(",")).map(String::trim).toArray(String[]::new);
    }

    private int inputRepeatCount() {
        System.out.println(ViewMsg.START_MSG_REPEAT.getMsg());
        return inputNumber();
    }

    private String inputString() {
        return scanner.nextLine();
    }

    private int inputNumber() {
        return scanner.nextInt();
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getrepeatCount() {
        return repeatCount;
    }


}
