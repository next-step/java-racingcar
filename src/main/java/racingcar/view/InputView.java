package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPLITTER = ",";
    private static final String REQUEST_CAR_NAMES_INPUT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_MOVE_NUMS_INPUT = "시도할 회수는 몇 회인가요?";

    public String[] requestCarNames() {
        System.out.println(REQUEST_CAR_NAMES_INPUT);
        return SCANNER.next().split(SPLITTER);
    }

    public int requestMoveNums() {
        System.out.println(REQUEST_MOVE_NUMS_INPUT);
        return SCANNER.nextInt();
    }
}