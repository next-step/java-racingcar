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

    private InGameController(InputView inputView) {
        this.inputView = inputView;
        racingGame = new RacingGame(numberOfCar, VehicleType.CAR);
        registerVehicles();
        moveVehicles();
    }

    public static List<Vehicle> run(InputView inputView) {
        return new InGameController(inputView).raceVehicle;
    }

    void registerVehicles() {
        this.numberOfCar = inputView.userInteraction(Constants.INFORMATION_MESSAGE_GET_NUMBER_OF_CAR);
        raceVehicle = racingGame.registerVehicles(new MoveRandom(new Random()));
    }

    void moveVehicles() {
        this.time = inputView.userInteraction(Constants.INFORMATION_MESSAGE_GET_GAME_TIME);
        raceVehicle = racingGame.start(time);
    }
}
