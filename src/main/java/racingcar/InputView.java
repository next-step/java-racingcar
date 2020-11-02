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

    public String askCars() {
        System.out.println(MsgConst.ASK_CARS);
        return this.scanner.nextLine();
    }

    public int askTryNum() {
        System.out.println(MsgConst.ASK_HOW_MANY_TRIES);
        return this.scanner.nextInt();
    }

    private static class SingletonHelper {
        private static final InputView instance = new InputView();
    }
}
