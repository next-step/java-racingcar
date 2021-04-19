package step3.data;

import java.util.ArrayList;
import java.util.List;

public class Race {

  private Integer laps;

  private List<Car> carList;

  private List<LapResult> raceLog;

  private class LapResult {
    List<Boolean> moves;
  }

  public Integer getLaps(){
    return this.laps;
  }

  public void setLaps(int num) {
    this.laps = num;
  }

  public List<Car> getCarList() {
    return this.carList;
  }


  public Race() {
    this.laps = 0;
    this.carList = new ArrayList<>();
    this.raceLog = new ArrayList<>();
  }


}
