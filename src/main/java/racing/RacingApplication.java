package racing;

import racing.controller.GameController;

import java.util.Scanner;

public class RacingApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GameController gameController = new GameController(scanner);
        gameController.run();
    }
}
