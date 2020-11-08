package racingcar.view;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ClientView {

    private static final String SEPARATED_EXPRESSION = ",";
    private static final String CARNAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACEROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final int CARNAME_MAXIMUM = 5;

    private static final Scanner scanner = new Scanner(System.in);

    private ClientView() {
    }

    public static String[] inputCarName() {
        System.out.println(CARNAME_INPUT_MESSAGE);
        String[] carNames = scanner.next().split(SEPARATED_EXPRESSION);
        IntStream.range(0, carNames.length)
                .forEach(i ->validateInputCarNameRule(carNames[i]));
        return carNames;
    }

    private static void validateInputCarNameRule(String carName) {
        if (isNullOrEmpty(carName) || carName.length() > CARNAME_MAXIMUM) {
            throw new IllegalArgumentException("자동차 이름에 빈값은 사용할 수 없으며, 5자를 넘을 수 없습니다.");
        }
    }

    private static boolean isNullOrEmpty(String carName) {
        return carName == null && carName.length() == 0 ? true : false;
    }

    public static int inputTotalRound() {
        System.out.println(RACEROUND_INPUT_MESSAGE);
        int inputRound = scanner.nextInt();
        validateInputRound(inputRound);
        return inputRound;
    }

    private static void validateInputRound(int round) {
        if (round == 0) {
            throw new IllegalArgumentException("최소 1라운드 이상 입력해주셔야 합니다.");
        }
    }

}
