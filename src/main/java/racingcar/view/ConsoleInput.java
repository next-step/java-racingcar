package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CARS_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVEMENT_COUNT_QUESTION = "자동차의 이동 횟수는 몇번인가요?";

    public List<String> getCarNames() {
        System.out.println(CARS_NAME_QUESTION);
        String names = SCANNER.nextLine();
        return CarNameSeparator.separate(names);
    }

    public int getMovementCount() {
        System.out.println(MOVEMENT_COUNT_QUESTION);
        return SCANNER.nextInt();
    }

}
