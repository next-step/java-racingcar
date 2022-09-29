package racingcar;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int count = requestInputCount();
        int repeat = requestInputRepeat();

        Game game = new Game(count, repeat);
        game.start();
    }

    private static int requestInputCount() {
        System.out.println("자동차 대 수는 몇 대 인가요?");
        return scanNumber();
    }

    private static int requestInputRepeat() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanNumber();
    }

    private static int scanNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
