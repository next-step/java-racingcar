import game.Game;
import game.GameFactory;
import game.GameType;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What game do you want to play?");
        GameType gameType = GameType.valueOf(scanner.next());

        Game game = GameFactory.createGame(gameType);
        game.start();
    }
}
