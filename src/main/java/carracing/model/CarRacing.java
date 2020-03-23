package carracing.model;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

  private final int totalPeriod;
  private int presentPeriod;
  private List<Integer> carPositions;

  public CarRacing(int totalPeriod, int carCount) {
    this.totalPeriod = totalPeriod;
    this.presentPeriod = 0;
    this.carPositions = new ArrayList<>();
  }

  public List<Integer> getCarPositions() {
    return carPositions;
  }

  public void proceedOnePeriod() {

  }

  public void race() {

  }
}
