package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        GameManager gameManager = new GameManager();
        gameManager.activate(scanner);
    }
}
