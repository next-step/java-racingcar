package step5.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    private InputView() {
    }

    public static List<String> nameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String stringNames = scanner.nextLine().trim();
        if (!stringNames.contains(SEPARATOR)) {
            throw new RuntimeException("구분자는 \",\" 여야 합니다");
        }
        return Arrays.stream(stringNames.split(SEPARATOR))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int times() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int times = scanner.nextInt();
        if (times < 1) {
            throw new RuntimeException("0 이하의 숫자는 입력 불가능 합니다.");
        }
        return times;
    }

}
