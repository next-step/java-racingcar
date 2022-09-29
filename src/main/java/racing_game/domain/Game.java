package racing_game.domain;

import racing_game.view.CarResultView;

public class Game {

  public void run() {
    try {
      Config config = InputConfigManager.create().getConfig();
      Simulator simulationResult = Simulator.create(config).simulate();
      CarResultView.create().printResult(simulationResult);
    } catch (Exception e) {
      System.out.println("the game error occurred");
      e.printStackTrace();
    }
  }
}
