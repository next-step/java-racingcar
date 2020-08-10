package carracing;

import carracing.domain.Game;

import java.util.Scanner;

public class Application {
    public static void main(String arg[]) {
        System.out.println("==== start car racing ====");

        Scanner sc = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carConut = sc.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = sc.nextInt();

        Game game = new Game(carConut, tryCount);
        game.start();
    }
}
