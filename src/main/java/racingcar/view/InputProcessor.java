package racingcar.view;

import java.util.Scanner;

public class InputProcessor {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarNamesFromUser() {
        System.out.println("자동차 이름을 입력하세요, (단, 자동차 이름은 쉼표(,)로 구분해야 합니다.)");
        return scanner.nextLine();
    }

    public static String getTryCountsFromUser() {
        System.out.println("몇 회를 시도하실 건가요?");
        return scanner.nextLine();
    }
}
