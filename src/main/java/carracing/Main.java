package carracing;

import carracing.controller.CarRacingGame;
import carracing.view.Display;
import carracing.view.InputView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        String[] names = inputView.insertNamesOfCars();
        int playCount = inputView.insertNumberOfAttempts();
        scanner.close();

        CarRacingGame game = new CarRacingGame(names);
        for (int i = 0; i < playCount; i++) {
            game.play();
            Display.printCurrentStatus(game.getCars());
        }
        Display.printWinnerAnnouncement(game.getWinners());
    }
}
