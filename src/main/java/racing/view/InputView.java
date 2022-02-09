package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA = ",";

    private InputView() {
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.stream(SCANNER.nextLine().split(COMMA))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public static int getTryNumber() {
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 해주세요.");
        }
    }
}
