package laststep.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public static List<String> participants() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();
        validateSeparator(input);

        return Arrays.stream(input.split(SEPARATOR)).collect(Collectors.toList());
    }

    public static int howManyPlay() {
        System.out.println("시도할 회수는 몇회인가요?");
        return changeNumber(sc.nextLine());
    }

    private static int changeNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    private static void validateSeparator(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("',' 를 포함해서 입력해 주세요");
        }
    }

    private InputView() {}
}
