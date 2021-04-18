package step3.data;

import java.util.ArrayList;
import java.util.List;

public class Race {

  public Integer lap;

  public List<Car> carList;

  public List<RaceResult> raceLog;

  public class RaceResult {
    List<Boolean> moves;
  }

  public Race() {
    this.lap = 0;
    this.carList = new ArrayList<>();
    this.raceLog = new ArrayList<>();
  }


}
