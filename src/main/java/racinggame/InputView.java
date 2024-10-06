package racinggame;

import java.util.Scanner;

public class InputView {

    public static InputDto readCount() {
        Scanner scanner = new Scanner(System.in);
        int carCount = readCount("자동차 대수는 몇 대 인가요?", scanner);
        int repeat = readCount("시도할 회수는 몇 회 인가요?", scanner);
        return new InputDto(carCount, repeat);
    }

    private static int readCount(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextInt();
    }

}
