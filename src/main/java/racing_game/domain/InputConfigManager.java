package racing_game.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import racing_game.core.Positive;
import racing_game.view.InputView;

public class InputConfigManager extends ConfigManager {

  private final InputView<Positive> inputView;

  private InputConfigManager() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    this.inputView = InputView.create(reader);
  }

  public static InputConfigManager create() {
    return new InputConfigManager();
  }

  private void init() throws IOException {
    Positive carCount = inputView.fromInput("자동차 대수는 몇 대 인가요?", Positive.zero());
    Positive tryCount = inputView.fromInput("시도할 회수는 몇 회 인가요?", Positive.zero());
    simulationConfig = SimulationConfig.create(carCount, tryCount);
  }

  @Override
  public SimulationConfig getConfig() throws Exception {
    if (simulationConfig == null) {
      init();
    }
    return simulationConfig;
  }
}
