package racing.ui;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_OF_ATTEMPT_MESSAGE = "시도 횟수는 몇 회 인가요?";

    public static String[] inputParticipationCars() {
        System.out.println(CAR_NAME_MESSAGE);
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(",");
        validateName(names);

        return names;
    }

    static void validateName(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력 해주세요");
        }
    }

    public static int inputNumberOfAttempt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(NUMBER_OF_ATTEMPT_MESSAGE);

        int numberOfAttempt = scanner.nextInt();
        validateAttempt(numberOfAttempt);

        return numberOfAttempt;
    }

    static void validateAttempt(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("0 이하는 입력할 수 없습니다.");
        }
    }
}
