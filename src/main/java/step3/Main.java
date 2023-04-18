package step3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        CarRacingGame game = new CarRacingGame(carNum);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int playCount = scanner.nextInt();
        scanner.close();
        game.play(playCount);
    }
}
