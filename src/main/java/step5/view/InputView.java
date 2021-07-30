package step5.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String[] inputCount() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)");
        return scanner.nextLine().split(",");
    }

    public static int inputTimes() {
        System.out.println("주행할 횟수를 입력하세요.");
        return scanner.nextInt();
    }
}
