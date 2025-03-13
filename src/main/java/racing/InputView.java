package racing;

import java.util.Scanner;

public class InputView {
    public static int getNumberOfCars() {
        return getUserInputNumber("자동차 대수는 몇 대 인가요?");
    }

    public static int getNumberOfLaps() {
        return getUserInputNumber("시도할 회수는 몇 회 인가요?");
    }

    private static int getUserInputNumber(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
