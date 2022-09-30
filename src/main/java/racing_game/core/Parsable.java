package racing_game.core;

public interface Parsable<T> {
  boolean canParse(String value);

  T parse(String value);
}
