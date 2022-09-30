package racingcar.ui;

import java.util.Scanner;

public class InputView {
    private static final String CAR_DESCRIPTION = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_DESCRIPTION = "시도할 횟수는 몇 회 인가요?";

    private static final Scanner scanner= new Scanner(System.in);

    public static int getCarCount() {
        System.out.println(CAR_DESCRIPTION);
        return getPositiveInteger(scanner.nextLine());
    }

    public static int getTryCount() {
        System.out.println(TRY_DESCRIPTION);
        return getPositiveInteger(scanner.nextLine());
    }

    public static int getPositiveInteger(String value) {
        try {
            return Integer.parseUnsignedInt(value);
        } catch (Exception e){
            throw new RuntimeException("0 이상의 숫자만 입력해주세요.");
        }
    }
}
