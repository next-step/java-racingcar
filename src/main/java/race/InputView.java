package race;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner SCANNER = new Scanner(System.in);
    private final String CAR_NAME_SPLIT_REGEX = "\\s*,\\s*";

    public List<String> receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesString = SCANNER.nextLine();
        List<String> carNames = List.of(carNamesString.split(CAR_NAME_SPLIT_REGEX));
        return carNames;
    }

    public int receiveRaceCount() {
        System.out.println("시도할 회수는 몇 회인가요?");

        while (true) {
            try {
                int raceCount = SCANNER.nextInt();
                validateRaceCount(raceCount);
                return raceCount;
            } catch (NumberFormatException e) {
                System.out.println("1 ~ 9 사이의 유효한 숫자를 입력 해주세요.");
            }
        }
    }

    public void closeScanner() {
        if (SCANNER != null) {
            SCANNER.close();
        }
    }

    private void validateRaceCount(int raceCount) {
        if (raceCount <= 1) {
            throw new NumberFormatException("1 ~ 9 사이의 양수를 입력해주세요.");
        }
    }
}
