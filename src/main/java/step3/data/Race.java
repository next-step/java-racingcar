package step3.data;

import java.util.ArrayList;
import java.util.List;

public class Race {

  public Integer laps;

  public List<Car> carList;

  public List<LapResult> raceLog;

  public class LapResult {
    List<Boolean> moves;
  }

  public Race() {
    this.laps = 0;
    this.carList = new ArrayList<>();
    this.raceLog = new ArrayList<>();
  }


}
