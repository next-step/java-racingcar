package step4.racing.ui;

import step4.racing.domain.RacingInfo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String COUNT_MSG = "시도할 횟수는 몇회인가요?";
    private static final String WRONG_INPUT_TYPE = "이름은 문자열, 횟수는 숫자를 입력해주세요";

    private RacingInfo racingInfo;
    private int count;
    private String name;
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public RacingInfo inputStart() {
        try {
            System.out.println(INPUT_NAME_MSG);
            name = scanner.nextLine();
            System.out.println(COUNT_MSG);
            count = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(WRONG_INPUT_TYPE);
            scanner.close();
        }
        return new RacingInfo(name, count);
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}
