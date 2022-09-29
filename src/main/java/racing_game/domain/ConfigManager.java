package racing_game.domain;

// user input 말고, file 등 다양한 방법으로 게임 옵션을 받는 경우를 위해..
public abstract class ConfigManager {
  protected Config config;

  public abstract Config getConfig() throws Exception;
}
