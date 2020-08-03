package racing.view;

import java.util.Scanner;

public class RacingInputView {

    public static int carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = createScanner();
        return scanner.nextInt();
    }

    public static int raceCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        Scanner scanner = createScanner();
        return scanner.nextInt();
    }

    private static Scanner createScanner() {
        return new Scanner(System.in);
    }
}
