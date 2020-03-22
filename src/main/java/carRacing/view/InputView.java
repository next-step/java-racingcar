package carRacing.view;

import carRacing.Constants;
import carRacing.RacingGame;

import java.util.Scanner;

public class InputView {

    Scanner scanner;
    int numberOfCar;
    int time;

    private InputView() {
        scanner = new Scanner(System.in);
        setGame();
        new RacingGame(numberOfCar, time).move();
    }

    static public void gameStart() {
        new InputView();
    }

    private void setGame() {
        this.numberOfCar = getGameInformFromUser(Constants.INFORMATION_MESSAGE_GET_NUMBER_OF_CAR);
        this.time = getGameInformFromUser(Constants.INFORMATION_MESSAGE_GET_GAME_TIME);
    }

    private int getGameInformFromUser(String Message) {
        System.out.println(Message);
        return scanner.nextInt();
    }
}
