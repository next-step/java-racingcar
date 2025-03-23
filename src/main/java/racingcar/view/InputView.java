package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> getValidCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String carNamesInput = scanner.nextLine();
        if (this.isInvalidNamesInput(carNamesInput)) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다: [자동차 이름: " + carNamesInput + "]");
        }

        String[] names = carNamesInput.split(",");

        return Arrays.stream(names)
                .map(String::trim)
                .filter(this::validateBlankOrThrow)
                .collect(Collectors.toList());
    }

    private boolean validateBlankOrThrow(String trimmed) {
        if (trimmed.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다");
        }
        return true;
    }

    private boolean isInvalidNamesInput(String carNamesInput) {
        return carNamesInput == null || carNamesInput.isEmpty() || carNamesInput.isBlank();
    }

    public int getAttempts() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
