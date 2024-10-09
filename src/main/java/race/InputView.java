package race;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = SCANNER.nextLine();

        return Arrays.asList(names.split(DELIMITER));
    }

    public static int inputRoundCount() {
        System.out.println("라운드는 몇 회 인가요?");
        return SCANNER.nextInt();
    }
}
