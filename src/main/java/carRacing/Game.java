package carRacing;

import carRacing.domain.Car;
import carRacing.domain.MoveRandom;
import carRacing.domain.Vehicle;
import carRacing.view.InputView;

import java.util.List;
import java.util.Random;

public class Game {

    int numberOfCar;
    int time;

    private Game() {
        userInteraction();
        RacingGame racingGame = new RacingGame(numberOfCar, VehicleType.CAR);
        List<Vehicle> cars = racingGame.registerVehicles(new MoveRandom(new Random()));
        racingGame.start(time);
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
