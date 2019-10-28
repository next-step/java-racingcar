package step2.race.controller;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private static final String EMPTY = "";
    private static final int MINIMUM_CAR = 0;
    private static final int MINIMUM_MOVE = 0;

    private final Scanner scanner;

    public InputView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public Integer inputCarAmount() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        String input = scanner.nextLine();
        validateInput(input);

        int carAmount = Integer.parseInt(input);
        validateCarAmount(carAmount);

        return carAmount;
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

    private void validateInput(String amount) {
        if (amount == null || amount.trim().equals(EMPTY)) {
            throw new IllegalArgumentException(amount + "는 올바른 입력이 아닙니다.");
        }
    }

}
