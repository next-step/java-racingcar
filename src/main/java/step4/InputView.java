package step4;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String DELIMITER = ",";

    public static String[] getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = SCANNER.nextLine().split(DELIMITER);
        while (!validateCarNames(names)) {
            System.out.println("자동차 이름은 null 이거나 빈 문자열이거나 길이가 5를 초화할 수 없습니다.");
            names = SCANNER.nextLine().split(DELIMITER);
        }
        return names;
    }

    private static boolean validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.isBlank() || carName.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static int getRoundsInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        String value = SCANNER.nextLine();
        while (!validateRounds(value)) {
            System.out.println("양의 정수만 허용됩니다.");
            value = SCANNER.nextLine();
        }
        return Integer.parseInt(value);
    }

    public static boolean validateRounds(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}