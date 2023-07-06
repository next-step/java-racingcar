package car.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputService {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void validateCarName(final String str) {
        if (str.isBlank()) {
            throw new RuntimeException("입력값이 없습니다.");
        }
    }

    public static String enterCarName() throws IOException {
        String name = bufferedReader.readLine();
        validateCarName(name);
        return name;
    }

    public static void printName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static String enterCount() throws IOException {
        String count = bufferedReader.readLine();
        return count;
    }
}







