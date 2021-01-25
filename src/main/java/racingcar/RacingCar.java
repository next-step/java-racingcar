package racingcar;

import java.util.Scanner;
import racingcar.controller.GameController;

public class RacingCar {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        gameController.startGame(scanner);
    }
}
