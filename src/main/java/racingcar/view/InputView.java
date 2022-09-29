package racingcar.view;

import racingcar.constant.Question;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_ROUND = 0;

    private InputView() {}

    public static int roundScan() {
        System.out.println(Question.ROUND.getQuestion());
        return roundValidCheck(scanner.nextInt());
    }

    public static String[] carNamesScan() {
        System.out.println(Question.CAR_NAME.getQuestion());
        return carNameValidCheck(scanner.nextLine().split(","));
    }

    public static int roundValidCheck(int round) {
        if (round  < MIN_ROUND) {
            throw new RuntimeException("1이상 부터 가능합니다.");
        }
        return round;
    }

    public static String[] carNameValidCheck(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = removeSpace(carNames[i]);
            carNameLengthCheck(carNames[i]);
        }
        return carNames;
    }

    private static void carNameLengthCheck(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다");
        }
    }

    private static String removeSpace(String carName) {
        return carName.replaceAll("\\s", "");
    }

}
