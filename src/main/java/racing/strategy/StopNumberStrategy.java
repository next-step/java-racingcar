package racing.strategy;

public class StopNumberStrategy implements NumberGeneratorStrategy {

  public int getNumber() {
    return MIN_FOR_MOVE - 1;
  }
}
