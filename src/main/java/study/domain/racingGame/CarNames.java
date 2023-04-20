package study.domain.racingGame;

import java.util.LinkedList;
import java.util.List;

public class CarNames {

  private List<String> value;

  public CarNames() {
    this.value = new LinkedList<String>();
  }

  public void addName(String carName) {
    this.value.add(carName);
  }

  public int getTotalCount() {
    return  this.value.size();
  }
}
