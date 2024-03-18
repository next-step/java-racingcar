package step3_racing_car.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String REGEX = ",";

    public static List<String> scanCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return List.of(scanner.nextLine().split(REGEX));
    }

    public static int scanRoundCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
