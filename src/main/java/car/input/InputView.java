package car.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputView {

    public static BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final String INPUT_RACE_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String enterCarName() throws IOException {
        printName();
        return bufferedReader.readLine();
    }

    public static void printName() {
        System.out.println(INPUT_RACE_CAR_MESSAGE);
    }

    public static void printCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public static String enterCount() throws IOException {
        printCount();
        return bufferedReader.readLine();
    }
}







