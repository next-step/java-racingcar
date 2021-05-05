package step5.view;

import java.util.Arrays;
import java.util.Scanner;

import static step5.Util.getSplitInputs;

public class InputPrint {
    public static final String SYSTEM_MESSAGE_ASK_CAR_NAME = "> 경주할 자동차 이름을 입력하세요. 쉼표(,)로 구분하며 하나의 이름은 5글자를 넘길 수 없습니다.";
    public static final String SYSTEM_MESSAGE_ASK_LAP_COUNT = "> 시도할 횟수는 몇 회 인가요?";
    public static final String SYSTEM_MESSAGE_LAP_RETRY = "횟수는 최소 1회 이상이여야 합니다. 다시 입력해주세요.";
    public static final String ILLEGAL_EXCEPTION_MESSAGE = "유효하지 않은 값을 입력하셨습니다.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] getCarNames() {
        try {
            System.out.println(SYSTEM_MESSAGE_ASK_CAR_NAME);
            String inputs = SCANNER.nextLine();
            return getSplitInputs(inputs);
        } catch (Exception e) {
            throw new IllegalArgumentException(ILLEGAL_EXCEPTION_MESSAGE);
        }
    }

    public static int getLapCount() {
        try {
            return getCount(SYSTEM_MESSAGE_ASK_LAP_COUNT, SYSTEM_MESSAGE_LAP_RETRY);
        } catch (Exception e) {
            throw new IllegalArgumentException(ILLEGAL_EXCEPTION_MESSAGE);
        }
    }

    public static int getCount(String askMessage, String retryMessage) {
        int count;
        do {
            System.out.println(askMessage);
            count = SCANNER.nextInt();
            validateCount(retryMessage, count);
        } while (count < 1);
        return count;
    }

    private static void validateCount(String retryMessage, int count) {
        if (count < 1) {
            System.out.println(retryMessage);
        }
    }

    public void inputs(String[] carNames, int lapCount) {
        System.out.println("Racing Game Start...  Car Names : " + Arrays.toString(carNames) + "  Lap Count : " + lapCount);
    }
}
