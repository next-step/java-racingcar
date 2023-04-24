package step3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.next().split(",");
        CarRacingGame game = new CarRacingGame(names);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int playCount = scanner.nextInt();
        scanner.close();
        game.play(playCount);
        Display.notifyWinners(game.getWinners());
    }
}
