package car.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputView {

    public static BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final String INPUT_RACE_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String enterCarName() {
        System.out.println(INPUT_RACE_CAR_MESSAGE);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("자동차 이름이 잘 못되었습니다");
            return enterCarName();
        }
    }

    public static String enterCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("시도 횟수가 잘 못 입력 되었습니다.");
            return enterCount();
        }
    }
}
