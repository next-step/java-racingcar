package racing_game.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import racing_game.view.InputView;

public class InputConfigManager extends ConfigManager {

  private final InputView inputView;

  private InputConfigManager() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    this.inputView = InputView.create(reader);
  }

  public static InputConfigManager create() {
    return new InputConfigManager();
  }

  private void init() throws IOException {
    config =
        Config.create(
            inputView.getNumberInput("자동차 대수는 몇 대 인가요?"),
            inputView.getNumberInput("시도할 회수는 몇 회 인가요?"));
  }

  @Override
  public Config getConfig() throws Exception {
    if (config == null) {
      init();
    }
    return config;
  }
}
