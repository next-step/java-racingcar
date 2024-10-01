package race;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        System.out.println("자동차는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int inputRoundCount() {
        System.out.println("라운드는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
