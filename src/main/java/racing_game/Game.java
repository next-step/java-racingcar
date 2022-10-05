package racing_game;

import racing_game.domain.SimulationConfig;
import racing_game.controller.Simulator;
import racing_game.core.SnapShot;
import racing_game.domain.Distances;
import racing_game.domain.InputConfigManager;
import racing_game.view.CarResultView;

public class Game {

    // servlet
    public void run() {
        try {
            // 1. request
            SimulationConfig simulationConfig = InputConfigManager.getConfig();

            // 2. controller
            SnapShot<Distances> result = Simulator.create(simulationConfig).simulate();

            // 3. response - view resolve
            CarResultView.create().printResult(result);
        } catch (Exception e) {
            System.out.println("the game error occurred");
            e.printStackTrace();
        }
    }
}
