package racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return splitNames(input);
    }

    private List<String> splitNames(String input) {
        String[] tokens = input.split(",");
        List<String> result = new ArrayList<>();
        for (String token : tokens) {
            String trimmed = token.trim();
            if (!trimmed.isEmpty()) {
                result.add(trimmed);
            }
        }
        return result;
    }

    public int readTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("시도 회수는 숫자로 입력해야 합니다.");
        }
        int count = scanner.nextInt();
        if (count <= 0) {
            throw new IllegalArgumentException("시도 회수는 1 이상이어야 합니다.");
        }
        return count;
    }
}
