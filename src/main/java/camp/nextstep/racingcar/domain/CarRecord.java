package camp.nextstep.racingcar.domain;

import java.util.UUID;

public class CarRecord {

  private final int distance;

  public CarRecord(int distance) {
    this.distance = distance;
  }

  public int getDistance() {
    return distance;
  }

}
