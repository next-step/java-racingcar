package racing.io;

import java.util.Scanner;

public class InputView {

    public static int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return new Scanner(System.in).nextInt();
    }

    public static int getRaceCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return new Scanner(System.in).nextInt();
    }
}
