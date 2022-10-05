package racing_game.core;

import racing_game.domain.Distances;
import racing_game.domain.InputConfigManager;
import racing_game.view.CarResultView;

public class Game {

    public void run() {
        try {
            SimulationConfig simulationConfig = InputConfigManager.getConfig();
            SnapShot<Distances> result = Simulator.create(simulationConfig).simulate();
            CarResultView.create().printResult(result);
        } catch (Exception e) {
            System.out.println("the game error occurred");
            e.printStackTrace();
        }
    }
}
