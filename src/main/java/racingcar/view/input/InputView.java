package racingcar.view.input;

import utils.IntUtils;

import java.util.Scanner;

public class InputView {

    private InputView(){}
    
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntValue(String msg) {
        String input = getInput(msg);
        if(!IntUtils.isInt(input)) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
        return Integer.parseInt(input);
    }

    public static String getInput(String msg) {
        System.out.println(msg);
        return scanner.next();
    }
}