package racing.view;

import java.util.Scanner;

public class InputView {

    static Scanner scan = new Scanner(System.in);

    public static int getRacingCarInput() {
        System.out.println("자동차 대수는 몇대 인가요?");
        return Integer.parseInt(scan.nextLine());
    }

    public static int getRacingInput() {
        System.out.println("시도할 횟수는 몇회 인가요?");
        return Integer.parseInt(scan.nextLine());
    }
}
