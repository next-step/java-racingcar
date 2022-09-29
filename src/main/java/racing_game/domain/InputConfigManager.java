package racing_game.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import racing_game.core.Positive;
import racing_game.view.InputView;

public class InputConfigManager extends ConfigManager {

  private InputConfigManager() {}

  public static InputConfigManager create() {
    return new InputConfigManager();
  }

  private void init() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Positive numberOfCars = InputView.create("자동차 대수는 몇 대 인가요?", reader).getNumberInput();
    Positive numberOfTrials = InputView.create("시도할 회수는 몇 회 인가요?", reader).getNumberInput();
    config = Config.create(numberOfCars, numberOfTrials);
  }

  @Override
  public Config getConfig() throws Exception {
    if (config == null) {
      init();
    }
    return config;
  }
}
