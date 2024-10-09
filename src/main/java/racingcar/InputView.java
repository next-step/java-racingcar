package racingcar;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분");
        return SCANNER.nextLine().split(",");
    }

    public static int getRoundNumber() {
        System.out.println("시도 할 횟수는 몇 번 인가요?");
        return SCANNER.nextInt();
    }
}
