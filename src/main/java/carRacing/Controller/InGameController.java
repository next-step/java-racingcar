package carRacing.Controller;

import carRacing.Constants;
import carRacing.Domain.*;
import carRacing.view.InputView;

import java.util.Random;


public class InGameController {

    private InputView inputView;
    private RacingGame racingGame;

    String players;
    int time;

    private InGameController() {
        this.inputView = InputView.readyToInteraction();
        this.players = registerPlayers();
        this.racingGame = new RacingGame(players, VehicleType.CAR);
        this.time = moveVehicles();
    }

    public static InGameController init() {
        return new InGameController();
    }

    public Vehicles register() {
        return racingGame.registerVehicles(new MoveRandom(new Random()));
    }

    public Vehicles move(Vehicles raceVehicle) {
        return racingGame.rotate(raceVehicle);
    }

    public int getTime() {
        return time;
    }

    String registerPlayers() {
        return inputView.userInteractionString(Constants.INFORMATION_MESSAGE_GET_PLAYERS);
    }

    int moveVehicles() {
        return inputView.userInteractionNumber(Constants.INFORMATION_MESSAGE_GET_GAME_TIME);
    }
}
