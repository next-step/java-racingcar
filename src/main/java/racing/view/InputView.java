package racing.view;

import dto.Request;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_REQUEST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static final String ROUND_REQUEST = "시도할 회수는 몇 회 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static Request input() {
        return new Request(inputCarNames(), inputRound());
    }

    private static String inputCarNames() {
        System.out.println(CAR_NAMES_REQUEST);
        return scanner.next();
    }

    private static int inputRound() {
        System.out.println(ROUND_REQUEST);
        return scanner.nextInt();
    }
}
