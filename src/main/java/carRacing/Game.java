package carRacing;

import carRacing.view.InputView;

import java.util.Random;

public class Game {

    int numberOfCar;
    int time;

    private Game() {
        userInteraction();
        new RacingGame(numberOfCar, time).start(new MoveRandom(new Random()));
    }

    public static void start() {
        new Game();
    }

    private void userInteraction() {
        InputView inputView = InputView.readyToInteraction();
        this.numberOfCar = inputView.userInteraction(Constants.INFORMATION_MESSAGE_GET_NUMBER_OF_CAR);
        this.time = inputView.userInteraction(Constants.INFORMATION_MESSAGE_GET_GAME_TIME);
    }
}
