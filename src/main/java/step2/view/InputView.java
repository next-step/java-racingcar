package step2.view;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String EMPTY = "";
    private static final int MINIMUM_CAR = 1;
    private static final int MINIMUM_MOVE = 0;

    private final Scanner scanner;

    public InputView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String input = scanner.nextLine();
        validateInput(input);

        List<String> names = Arrays.asList(parseName(input));

        validateCarAmount(names.size());

        return names;
    }

    private String[] parseName(String input) {
        return input.split(DELIMITER);
    }

    public Integer inputMoveAmount() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        String input = scanner.nextLine();
        validateInput(input);

        int moveAmount = Integer.parseInt(input);
        validateMoveAmount(moveAmount);

        return moveAmount;
    }

    private void validateMoveAmount(int moveAmount) {
        if (moveAmount <= MINIMUM_MOVE) {
            throw new IllegalArgumentException(moveAmount + "보다 많은 수의 시도 횟수가 필요합니다.");
        }
    }

    private void validateCarAmount(Integer carAmount) {
        if (carAmount <= MINIMUM_CAR) {
            throw new IllegalArgumentException(carAmount + "보다 많은 수의 자동차가 필요합니다.");
        }
    }

    private void validateInput(String input) {
        if (input == null || input.trim().equals(EMPTY)) {
            throw new IllegalArgumentException(input + "는 올바른 입력이 아닙니다.");
        }
    }

}
