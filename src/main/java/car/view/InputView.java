package car.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAMES_SPLIT_DELIMITER = ",";

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return split(scanner.nextLine());
    }

    public static int getPlayCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }

    private static List<String> split(String names) {
        return List.of(names.split(NAMES_SPLIT_DELIMITER));
    }
}
