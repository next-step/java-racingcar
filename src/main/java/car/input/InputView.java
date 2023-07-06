package car.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputView {

    public static BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final String INPUT_RACE_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String WRONG_COUNT_MESSAGE = "시도 횟수가 잘 못 입력 되었습니다.";
    private static final String WRONG_CAR_NAME_MESSAGE = "자동차 이름이 잘 못되었습니다";

    public static String enterCarName() {
        printName();
        try {
            String carName = bufferedReader.readLine();
            return carName;
        } catch (IOException e) {
            System.out.println(WRONG_CAR_NAME_MESSAGE);
            return enterCarName();
        }
    }

    public static void printName() {
        System.out.println(INPUT_RACE_CAR_MESSAGE);
    }

    public static void printCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public static String enterCount() {
        printCount();
        try {
            String count = bufferedReader.readLine();
            return count;
        } catch (IOException e) {
            System.out.println(WRONG_COUNT_MESSAGE);
            return enterCount();
        }
    }
}







