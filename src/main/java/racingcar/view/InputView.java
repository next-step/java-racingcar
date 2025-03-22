package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> getValidCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String carNamesInput = scanner.nextLine();
        if (this.isInvalidNamesInput(carNamesInput)) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다: [자동차 이름: " + carNamesInput + "]");
        }

        String[] names = carNamesInput.split(",");

        List<String> result = new ArrayList<>();
        for (String name : names) {
            String trimmed = name.trim();
            this.validateBlankOrThrow(trimmed);
            result.add(trimmed);
        }
        return result;
    }

    private void validateBlankOrThrow(String trimmed) {
        if (trimmed.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다");
        }
    }

    private boolean isInvalidNamesInput(String carNamesInput) {
        return carNamesInput == null || carNamesInput.isEmpty() || carNamesInput.isBlank();
    }

    public int getAttempts() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
