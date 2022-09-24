package step3;

import java.util.Scanner;

public class InputView {

    public static final String CAR_NUM_TEXT = "자동차 대수는 몇 대 인가요?";
    public static final String TRY_NUM_TEXT = "시도할 회수는 몇 회 인가요?";

    public static int[] input() {
        Scanner scanner = new Scanner(System.in);
        int[] result = new int[2];

        System.out.println(CAR_NUM_TEXT);
        result[0] = scanner.nextInt();
        System.out.println(TRY_NUM_TEXT);
        result[1] = scanner.nextInt();

        return result;
    }
}
