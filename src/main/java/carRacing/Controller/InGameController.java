package carRacing.Controller;

import carRacing.Constants;
import carRacing.Domain.MoveRandom;
import carRacing.Domain.RacingGame;
import carRacing.Domain.Vehicle;
import carRacing.Domain.VehicleType;
import carRacing.view.InputView;

import java.util.List;
import java.util.Random;


public class InGameController {

    private InputView inputView;
    private RacingGame racingGame;
    private List<Vehicle> raceVehicle;

    int numberOfCar;
    int time;

    private InGameController() {
        this.inputView = InputView.readyToInteraction();
        registerVehicles();
        this.racingGame = new RacingGame(numberOfCar, VehicleType.CAR);
        raceVehicle = racingGame.registerVehicles(new MoveRandom(new Random()));
        moveVehicles();
    }

    public static InGameController run() {
        return new InGameController();
    }

    public List<Vehicle> move() {
        return racingGame.rotate(raceVehicle);
    }

    public int getTime() {
        return time;
    }

    void registerVehicles() {
        this.numberOfCar = inputView.userInteraction(Constants.INFORMATION_MESSAGE_GET_NUMBER_OF_CAR);
    }

    void moveVehicles() {
        this.time = inputView.userInteraction(Constants.INFORMATION_MESSAGE_GET_GAME_TIME);
    }
}
