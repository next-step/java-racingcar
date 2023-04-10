package racing;

import racing.domain.RacingGame;

import java.util.Scanner;

public class RacingApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.start();
    }
}
