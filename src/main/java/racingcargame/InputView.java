package racingcargame;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public int getCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int getPlayCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
