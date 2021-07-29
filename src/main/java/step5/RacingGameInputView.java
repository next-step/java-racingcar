package step5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGameInputView {

    public static RacingGameConfiguration getRacingGameConfigurationWithPrompt() {
        try (Scanner standardInput = new Scanner(System.in)) {
            List<String> carNames = null;

            do {
                printIfInputAgain(carNames);

                System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
                carNames = parseNames(standardInput.nextLine());
            } while(!validateNames(carNames));

            System.out.println("시도할 회수는 몇 회 인가요?");
            int nTurns = standardInput.nextInt();

            return new RacingGameConfiguration(carNames, nTurns);
        }
    }

    private static void printIfInputAgain(List<String> carNames) {
        if (carNames != null) {
            System.out.println("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static List<String> parseNames(String namesString) {
        return Arrays.asList(namesString.split(","));
    }

    private static boolean validateNames(List<String> names) {
        return names.stream().map(CarName::isValidCarName)
                .reduce((returnValue, result) -> returnValue & result)
                .orElse(false);
    }
}
