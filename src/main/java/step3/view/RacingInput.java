package step3.view;

import java.util.Scanner;

public class RacingInput {
    private static final String DELIMETER = ",";

    private static final String INPUT_TIMES = "시도할 회수는 몇 회 인가요";
    private static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public int inputGameCoin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_TIMES);
        int scanNumber = scanner.nextInt();
        return scanNumber;
    }

    public String[] inputCarNames() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_CARS);
        String scanString = scanner.nextLine();

        return scanString.split(DELIMETER);
    }
}

