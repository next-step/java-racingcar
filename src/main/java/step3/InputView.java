package step3;

import java.util.Scanner;

public class InputView {
    private static Scanner SCANNER = new Scanner(System.in);
    private static String ASK_QUESTION_FOR_A_NUM_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static String ASK_QUESTION_FOR_A_NUM_OF_TRIAL = "시도할 회수는 몇 회 인가요?";

    public static int getNumOfCar() {
        System.out.println(ASK_QUESTION_FOR_A_NUM_OF_CAR);
        String numOfCar = SCANNER.nextLine();
        if (!checkIfPositive(numOfCar)) {
            throw new RuntimeException("자동차 대수는 양수여야 합니다.");
        }
        return Integer.parseInt(numOfCar);
    }

    public static int getNumOfTrial() {
        System.out.println(ASK_QUESTION_FOR_A_NUM_OF_TRIAL);
        String numOfTrial = SCANNER.nextLine();
        if (!checkIfPositive(numOfTrial)) {
            throw new RuntimeException("시도할 횟수는 양수여야 합니다.");
        }
        return Integer.parseInt(numOfTrial);
    }

    public static boolean checkIfPositive(String strValue) {
        if (!isNumber(strValue) || Integer.parseInt(strValue) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isNumber(String strValue) {
        return strValue != null && strValue.matches("[-+]?\\d*\\.?\\d+");
    }
}
