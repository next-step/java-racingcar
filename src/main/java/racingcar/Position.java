package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Position {

  private List<int[]> carPosition = new ArrayList<>();

  public void add(int[] carPosition) {
    this.carPosition.add(carPosition);
  }

  public List getCarPosition() {
    return carPosition;
  }

  public int[] getCarPosition(int time) {
    return carPosition.get(time);
  }

  public int numberOfTimes() {
    return carPosition.size();
  }

}
