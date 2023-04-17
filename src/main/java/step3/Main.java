package step3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRacingGame game = new CarRacingGame();

        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carNum = scanner.nextInt();
        game.setCars(carNum);

        System.out.println("시도할 회수는 몇 회 인가요?");
        scanner = new Scanner(System.in);
        int playCount = scanner.nextInt();
        game.play(playCount);
    }
}
