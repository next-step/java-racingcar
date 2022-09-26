package racingcar;

import java.util.Scanner;

public class ConsoleInput {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_QUANTITY_QUESTION = "경기에 출전할 자동차 수는 몇대인가요?";
    private static final String MOVEMENT_COUNT_QUESTION = "자동차의 이동 횟수는 몇번인가요?";

    public int getCarQuantity() {
        System.out.println(CAR_QUANTITY_QUESTION);
        return SCANNER.nextInt();
    }

    public int getMovementCount() {
        System.out.println(MOVEMENT_COUNT_QUESTION);
        return SCANNER.nextInt();
    }

}
