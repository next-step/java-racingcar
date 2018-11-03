package racing;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int num = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        try {
            RacingGame racingGame = new RacingGame(time, num);
            racingGame.start();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
