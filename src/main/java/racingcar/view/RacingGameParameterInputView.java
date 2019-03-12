package racingcar.view;

import org.apache.commons.lang3.StringUtils;
import racingcar.vo.RacingGameParameter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameParameterInputView {
    private RacingGameParameterInputView() {
    }

    public static RacingGameParameter readRacingGameParameter() {
        try (Scanner scanner = new Scanner(System.in)) {
            String carNamesString = readCarNames(scanner);
            int totalRound = readTotalRound(scanner);
            System.out.println();

            List<String> carNames = convertCarNamesStringToList(carNamesString);
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
        int totalCount;

        do {
            System.out.println("시도할 회수는 몇 회 인가요?");
            totalCount = scanner.nextInt();
        } while (totalCount <= 0);

        return totalCount;
    }


    private static List<String> convertCarNamesStringToList(String carNamesString) {
        return Arrays.stream(carNamesString.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

}
