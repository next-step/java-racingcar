package racingcar.ui;

import java.util.Scanner;
//        RacingInputView inputView = new RacingInputView(new Scanner(System.in));
public class RacingInputView {
    private static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }

    public static void initScanner(Scanner scanner){
        RacingInputView.scanner = scanner;
    }

    public static int carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int raceTimes() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
