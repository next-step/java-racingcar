package step4;

import java.util.Arrays;
import java.util.Scanner;

public class InputPrint {
    public static final String SYSTEM_MESSAGE_ASK_CAR_NAME = "> 경주할 자동차 이름을 입력하세요. 쉼표(,)로 구분하며 하나의 이름은 5글자를 넘길 수 없습니다.";
    public static final String SYSTEM_MESSAGE_ASK_LAP_COUNT = "> 시도할 횟수는 몇 회 인가요?";
    public static final String SYSTEM_MESSAGE_LAP_RETRY = "횟수는 최소 1회 이상이여야 합니다. 다시 입력해주세요.";
    public static final String ILLEGAL_EXCEPTION_MESSAGE = "유효하지 않은 값을 입력하셨습니다.";

    public static final int MAX_NAME_SIZE = 5;

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        try {
            System.out.println(SYSTEM_MESSAGE_ASK_CAR_NAME);
            String inputs = scanner.nextLine();
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
            count = scanner.nextInt();
            validateCount(retryMessage, count);
        } while (count < 1);
        return count;
    }

    private static void validateCount(String retryMessage, int count) {
        if (count < 1) {
            System.out.println(retryMessage);
        }
    }

    /**
     * 입력값 나누기 & validation
     *
     */
    public static String[] getSplitInputs(String input) {
        input = input.replace(" ", "");
        if (input.replace(",", "").length() == 0) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        String[] names = input.split(",");
        for (String s : names) {
            validateNameSize(s);
        }
        return names;
    }

    private static void validateNameSize(String names) {
        if (names.length() > MAX_NAME_SIZE)
            throw new IllegalArgumentException("이름은 " + MAX_NAME_SIZE + "글자를 넘어갈 수 없습니다.");
    }

    public void checkInputs(String[] carNames, int lapCount) {
        System.out.println("Racing Game Start...  Car Names : " + Arrays.toString(carNames) + "  Lap Count : " + lapCount);
    }
}
