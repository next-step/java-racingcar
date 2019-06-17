package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Position {

  private List<List<Integer>> carPosition = new ArrayList<>();

  public void add(List<Integer> carPosition) {
    this.carPosition.add(carPosition);
  }

  public List getCarPosition() {
    return carPosition;
  }

  public List<Integer> getCarPosition(int time) {
    return carPosition.get(time);
  }

  public int numberOfTimes() {
    return carPosition.size();
  }

}
