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

    private boolean validateNameCsv(String nameCsv) {
        String[] nameArr = nameCsv.split(CarGroupConst.NAME_SPLIT_REGEX);
        boolean validation = true;
        for (String name : nameArr) {
            validation &= Car.validateName(name);
        }
        return validation;
    }

    public String askNames() {
        System.out.println(InputViewConst.ASK_CARS);
        String nameCsv = this.scanner.nextLine();
        this.validateNameCsv(nameCsv);
        return nameCsv;
    }

    public int askMaxRaceNum() {
        System.out.println(InputViewConst.ASK_HOW_MANY_RACES);
        return this.scanner.nextInt();
    }

    private static class SingletonHelper {
        private static final InputView instance = new InputView();
    }
}
