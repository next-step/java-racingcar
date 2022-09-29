package racingcar.view;

import racingcar.constant.Question;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int carCountScan() {
        System.out.println(Question.carCount.getQuestion());
        return scanner.nextInt();
    }

    public static int roundScan() {
        System.out.println(Question.round.getQuestion());
        return scanner.nextInt();
    }

    public static String[] carNamesScan() {
        System.out.println(Question.carName.getQuestion());
        return carNameValidCheck(scanner.nextLine().split(","));
    }

    public static String[] carNameValidCheck(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = removeSpace(carNames[i]);
            carNameLengthCheck(carNames[i]);
        }
        return carNames;
    }

    private static void carNameLengthCheck(String carName) {
        if (carName.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다");
        }
    }

    private static String removeSpace(String carName) {
        return carName.replaceAll("\\s", "");
    }
}
