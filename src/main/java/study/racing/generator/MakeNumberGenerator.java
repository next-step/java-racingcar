package study.racing.generator;

import java.util.List;

public class MakeNumberGenerator implements Generator{

  private final List<Integer> numbers;

  private int index = 0;

  public MakeNumberGenerator(List<Integer> numbers) {
    this.numbers = numbers;
  }

  @Override
  public int generateNewNumber() {
    return numbers.get(index++ % numbers.size());
  }
}
