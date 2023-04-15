package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static int carInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextInt();
    }

    public static List<String> carNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String inputNames = SCANNER.next();
        return splitCarNames(inputNames);
    }

    public static int stageInput() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }

    private static List<String> splitCarNames(String inputNames) {
        String[] names = inputNames.split(DELIMITER);
        return List.of(names);
    }
}
