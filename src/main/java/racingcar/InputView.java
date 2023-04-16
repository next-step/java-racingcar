package racingcar;

import java.util.Scanner;

public class InputView {

    private static final String ASK_CAR_MENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_ROUND_MENT = "시도할 회수는 몇 회 인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String askCar() {
        System.out.println(ASK_CAR_MENT);
        return SCANNER.nextLine();
    }

    public static int askRound() {
        System.out.println(ASK_ROUND_MENT);
        return Integer.parseInt(SCANNER.nextLine());
    }


}
