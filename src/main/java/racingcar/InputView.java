package racingcar;

import java.util.Scanner;

public class InputView {
    // NOTE: Scanner 는 thread-unsafe 하므로 싱글톤 패턴을 적용한다.
    private Scanner scanner;

    private InputView() {
        this.scanner = new Scanner(System.in);
    }

    public static InputView getInstance() {
        return SingletonHelper.instance;
    }

    private int askNum(String questionMsg) {
        System.out.println(questionMsg);
        return this.scanner.nextInt();
    }

    public int askCarNum() {
        return this.askNum(MsgConst.HOW_MANY_CARS_STR);
    }

    public int askTryNum() {
        return this.askNum(MsgConst.HOW_MANY_TRIES_STR);
    }

    public void printResultMsg() {
        System.out.println(MsgConst.EXECUTION_RESULT_STR);
    }

    private static class SingletonHelper {
        private static final InputView instance = new InputView();
    }
}
