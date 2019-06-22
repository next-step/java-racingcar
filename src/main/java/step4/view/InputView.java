package step4.view;

import step4.domain.CarNames;
import step4.domain.Round;

import java.util.Scanner;

public class InputView {
    private final static String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private final static String ASK_ROUND = "시도할 횟수는 몇 회 인가요?";
    private static Scanner scanner = new Scanner(System.in);

    public static CarNames getCarNames() {
        System.out.println(ASK_CAR_NAMES);
        return CarNames.from(scanner.nextLine());
    }

    public static Round getRound() {
        System.out.println(ASK_ROUND);
        return Round.from(scanner.nextInt());
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
