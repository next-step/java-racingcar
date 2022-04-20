package camp.nextstep.racingcar.domain;

import java.util.UUID;

public class CarRecord {

  private final String name;
  private final int distance;

  public CarRecord(String name, int distance) {
    this.name = name;
    this.distance = distance;
  }

  public int getDistance() {
    return distance;
  }

  public String getName() {
    return name;
  }

}
