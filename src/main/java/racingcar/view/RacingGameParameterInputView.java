package racingcar.view;

import org.apache.commons.lang3.StringUtils;
import racingcar.vo.RacingGameParameter;

import java.util.List;
import java.util.Scanner;

public class RacingGameParameterInputView {
    private static final int MINIMUM_ROUND = 1;

    private RacingGameParameterInputView() {
    }

    public static RacingGameParameter readRacingGameParameter() {
        try (Scanner scanner = new Scanner(System.in)) {
            String carNamesString = readCarNames(scanner);
            int totalRound = readTotalRound(scanner);
            System.out.println();

            List<String> carNames = CarNameParser.parseCommaCarNamesString(carNamesString);
            return new RacingGameParameter(carNames, totalRound);
        }
    }

    private static String readCarNames(Scanner scanner) {
        String carNames;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            carNames = scanner.nextLine();
        } while (StringUtils.isBlank(carNames));

        return carNames;
    }

    private static int readTotalRound(Scanner scanner) {
        int totalRound;

        do {
            System.out.println("시도할 회수는 몇 회 인가요?");
            totalRound = scanner.nextInt();
        } while (totalRound < MINIMUM_ROUND);

        return totalRound;
    }
}
