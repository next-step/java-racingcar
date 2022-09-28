package racingcar;

import java.util.Scanner;

public class ConsoleInput {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_QUANTITY_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVEMENT_COUNT_QUESTION = "자동차의 이동 횟수는 몇번인가요?";

    public String getCarNames() {
        System.out.println(CAR_QUANTITY_QUESTION);
        return SCANNER.nextLine();
    }

    public int getMovementCount() {
        System.out.println(MOVEMENT_COUNT_QUESTION);
        return SCANNER.nextInt();
    }

}
