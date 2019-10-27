package step2;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public int createCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int moveCarCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
