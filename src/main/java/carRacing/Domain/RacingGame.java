package carRacing.Domain;

import carRacing.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RacingGame {

    List<String> players;
    VehicleType vehicleType;

    public RacingGame(String players, VehicleType vehicleType) {
        this.players = registerPlayer(players);
        this.vehicleType = vehicleType;
    }

    private List<String> registerPlayer(String players) {
        emptyInputException(players);
        return new ArrayList<>(Arrays.asList(players.split(Constants.INPUT_PLAYERS_SEPARATE_SYMBOL)));
    }

    private void emptyInputException(String players) {
        if (players == null || players.trim().isEmpty()) throw new IllegalArgumentException();
    }

    public Vehicles registerVehicles(MoveStrategy moveStrategy) {
        List<Vehicle> racingVehicles = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            racingVehicles.add(vehicleType.init(players.get(i), moveStrategy));
        }
        return Vehicles.create(racingVehicles);
    }

    public Vehicles rotate(Vehicles vehicles) {
        return vehicles.move();
    }
}
