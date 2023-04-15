package racing.strategy;

public interface NumberGeneratorStrategy {

  int MIN_FOR_MOVE = 4;
  int MAX_FOR_MOVE = 9;

  int getNumber();

}
