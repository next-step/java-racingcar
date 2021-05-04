package racing.view;

import java.util.Objects;
import java.util.Scanner;

public class ReceivingRacingGameInput {
    private final Scanner scanner;

    public ReceivingRacingGameInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveCarNames() {
        String carNames;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
            carNames = scanner.nextLine();
        } while (isEmpty(carNames));
        return carNames;
    }

    private boolean isEmpty(String carNames) {
        return carNames == null || carNames.isEmpty();
    }

    public int receiveRoundNumber() {
        String roundNumber;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            roundNumber = scanner.nextLine();
        } while (isEmptyOrNull(roundNumber) || !isNumber(roundNumber));
        return Integer.parseInt(roundNumber);
    }

    private boolean isEmptyOrNull(String roundNumber) {
        return Objects.isNull(roundNumber) || roundNumber.isEmpty();
    }

    private boolean isNumber(String roundNumber) {
        try {
            return Integer.valueOf(roundNumber) instanceof Integer;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
