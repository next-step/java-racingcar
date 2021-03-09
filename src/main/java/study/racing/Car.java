package study.racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

  private List<Integer> numbers = new ArrayList<>();

  private int moveCount = 0;

  public Car() {
  }

  public Car(int tryCount) {
    assignNumber(tryCount);
  }

  public Car(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public void assignNumber(int tryCount) {
    for (int i = 0; i < tryCount; i++) {
      numbers.add(RandomNumberAssigner.getRandomNumber());
    }
  }

  public boolean checkMove(int index) {
    int number = numbers.get(index);
    if (number >= 4) {
      moveCount ++;
      return true;
    }
    return false;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public int getMoveCount() {
    return moveCount;
  }
}
