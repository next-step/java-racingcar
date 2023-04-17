package view;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String[] splitNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameOfCars = SCANNER.next();
        return nameOfCars.split(",");
    }

    public static int trial() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String trial = SCANNER.next();
        if (isInvalidValue(trial)) {
            return trial();
        }

        return parseInt(trial);
    }

    private static boolean isInvalidValue(String trial) {
        if (parseInt(trial) < 0) {
            System.out.println("0 이상의 수만 입력하세요.");
            return true;
        }
        return false;
    }
}
