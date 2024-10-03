package race;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private final String CAR_NAME_SPLIT_REGEX = "\\s*,\\s*";
    private final int MIN_CAR_COUNT = 1;
    private final int MAX_CAR_COUNT = 5;
    private final int MIN_RACE_COUNT = 1;
    private final int MAX_RACE_COUNT = 9;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public InputView() {
        this(new Scanner(System.in));
    }
    public List<String> receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesString = scanner.nextLine();
        List<String> carNames = List.of(carNamesString.split(CAR_NAME_SPLIT_REGEX));
        validateCarNamesCount(carNames);
        return carNames;
    }

    private void validateCarNamesCount(List<String> carNames) {
        if (carNames.size() < MIN_CAR_COUNT || carNames.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException("경주 할 자동차 이름을 1~5대 사이로 입력 해 주시기 바랍니다.");
        }
    }

    public int receiveRaceCount() {
        System.out.println("시도할 회수는 몇 회인가요?");

        while (true) {
            try {
                int raceCount = scanner.nextInt();
                validateRaceCount(raceCount);
                return raceCount;
            } catch (InputMismatchException e) {
                throw new InputMismatchException("1 ~ 9 사이의 유효한 숫자를 입력 해주세요.");
            }
        }
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

    private void validateRaceCount(int raceCount) {
        if (raceCount < MIN_RACE_COUNT || raceCount > MAX_RACE_COUNT) {
            throw new IllegalArgumentException("우");
        }
    }
}
