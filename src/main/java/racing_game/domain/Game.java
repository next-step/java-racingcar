package racing_game.domain;

import racing_game.core.SnapShot;
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
