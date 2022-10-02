package racing_game.domain;

import racing_game.view.CarResultView;

public class Game {

  public void run() {
    try {
      SimulationConfig simulationConfig = InputConfigManager.create().getConfig();
      Simulator simulationResult = Simulator.create(simulationConfig).simulate();
      CarResultView.create().printResult(simulationResult);
    } catch (Exception e) {
      System.out.println("the game error occurred");
      e.printStackTrace();
    }
  }
}
