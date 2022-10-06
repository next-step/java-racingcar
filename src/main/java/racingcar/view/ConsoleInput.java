package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleInput() {
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = SCANNER.nextLine();
        return CarNameSeparator.separate(names);
    }

    public static int getMovementCount() {
        System.out.println("자동차의 이동 횟수는 몇번인가요?");
        return SCANNER.nextInt();
    }

}
