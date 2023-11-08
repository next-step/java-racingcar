package racing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {
    private static final String NUMBER = "number";
    private static final String COUNT = "count";

    public static Map<String, Integer> inputResult() {
        Map<String, Integer> input = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        input.put(NUMBER, scanner.nextInt());

        System.out.println("시도할 회수는 몇 회 인가요?");
        input.put(COUNT, scanner.nextInt());

        return input;
    }
}
