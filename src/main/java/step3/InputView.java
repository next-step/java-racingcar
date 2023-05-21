package step3;

import java.util.Scanner;

public class InputView {
    private static Scanner SCANNER = new Scanner(System.in);
    private static String ASK_QUESTION_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String ASK_QUESTION_FOR_A_NUM_OF_TRIAL = "시도할 회수는 몇 회 인가요?";

    public static String[] getCarNames() {
        System.out.println(ASK_QUESTION_FOR_CAR_NAMES);
        String[] carNames = SCANNER.nextLine().split(",");
        validateCarNamesLengthInRange(carNames);
        return carNames;
    }

    public static void validateCarNamesLengthInRange(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new RuntimeException("자동차 이름은 5자를 초과할 수 앖습니다.");
            }
        }
    }

    public static int getNumOfTrial() {
        System.out.println(ASK_QUESTION_FOR_A_NUM_OF_TRIAL);
        String numOfTrial = SCANNER.nextLine();
        validatePositive(numOfTrial);
        return Integer.parseInt(numOfTrial);
    }

    public static void validatePositive(String strValue) {
        if (!isNumber(strValue) || Integer.parseInt(strValue) <= 0) {
            throw new RuntimeException("시도할 횟수는 양수여야 합니다.");
        }
    }

    public static boolean isNumber(String strValue) {
        return strValue != null && strValue.matches("[-+]?\\d*\\.?\\d+");
    }
}
