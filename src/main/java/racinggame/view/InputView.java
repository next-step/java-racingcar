package racinggame.view;

import static java.lang.System.out;

import java.util.Scanner;

public class InputView {

    public static String carCount(Scanner scanner) {
        out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextLine();
    }

    public static int playCount(Scanner scanner) {
        out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

}
