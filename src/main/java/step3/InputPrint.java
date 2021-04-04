package step3;

import java.util.Scanner;

public class InputPrint {
    public static final String SYSTEM_MESSAGE_ASK_CAR_COUNT = "> 자동차 대수는 몇 대 인가요?";
    public static final String SYSTEM_MESSAGE_ASK_LAP_COUNT = "> 시도할 횟수는 몇 회 인가요?";
    public static final String SYSTEM_MESSAGE_CAR_RETRY = "자동차는 최소 1대 이상이여야 합니다. 다시 입력해주세요.";
    public static final String SYSTEM_MESSAGE_LAP_RETRY = "횟수는 최소 1회 이상이여야 합니다. 다시 입력해주세요.";
    public static final String ILLEGAL_EXCEPTION_MESSAGE = "유효하지 않은 값을 입력하셨습니다.";

    private static Scanner scanner = new Scanner(System.in);

    public static int getCarCount() {
        try {
            return getCount(SYSTEM_MESSAGE_ASK_CAR_COUNT, SYSTEM_MESSAGE_CAR_RETRY);
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
            if (count < 1) {
                System.out.println(retryMessage);
            }
        } while (count < 1);
        return count;
    }

    public void checkInputs(int carCount, int lapCount){
        System.out.println("Racing Game Start...  Car Count : " + carCount + "  Lap Count : " +lapCount);
    }
}
