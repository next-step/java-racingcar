package racingcar;

import java.util.List;

public class GameRunner implements Game {

    private final Game game;

    public GameRunner(Game game) {
        this.game = game;
    }

    @Override
    public void start() {
        game.start();
    }

    @Override
    public List<Vehicle> getVehicles() {
        return game.getVehicles();
    }

    private void displayResult() {
        List<Vehicle> vehicles = getVehicles();
        vehicles.forEach(vehicle -> {
            System.out.println(String.format("%s : %s", vehicle.getName(), vehicle.toString()));
        });
        System.out.println();
    }
}
