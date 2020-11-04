package racingcar;

import java.util.Scanner;

public class InputView {
    // NOTE: Scanner 는 thread-unsafe 하므로 싱글톤 패턴을 적용한다.
    private Scanner scanner;

    private InputView() {
        if (this.scanner != null) {
            return;
        }
        this.scanner = new Scanner(System.in);
    }

    public static InputView getInstance() {
        return SingletonHelper.instance;
    }

    public String askCars() {
        System.out.println(InputViewConst.ASK_CARS);
        String nameCsv = this.scanner.nextLine();
        String[] nameArr = nameCsv.split(CarGroupConst.NAME_SPLIT_REGEX);
        for (String name : nameArr) {
            Car.validateName(name);
        }
        return nameCsv;
    }

    public int askTryNum() {
        System.out.println(InputViewConst.ASK_HOW_MANY_TRIES);
        return this.scanner.nextInt();
    }

    private static class SingletonHelper {
        private static final InputView instance = new InputView();
    }
}
