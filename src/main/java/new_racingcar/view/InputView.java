package new_racingcar.view;

import new_racingcar.constant.MsgConstants;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public List<String> inputNames() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(MsgConstants.INPUT_CAR_NAME_MESSAGE);
        String names = scanner.next();

        isStringEmpty(names);
        return Arrays.asList(names.split(","));
    }

    public void isStringEmpty(String names) {
        if (names == null
            || names.trim().isEmpty()) {
            throw new IllegalArgumentException(MsgConstants.INPUT_CAR_NAME_ERROR);
        }
    }

    public int inputTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MsgConstants.INPUT_TURN_MESSAGE);
        return scanner.nextInt();
    }
}
