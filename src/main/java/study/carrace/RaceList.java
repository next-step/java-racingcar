package study.carrace;

public class RaceList {
  Race[] races;

  public RaceList(Race[] races) {
    this.races = races;
  }

  public Race[] getRaces() {
    return races;
  }

  public String winner() {
    String winners = "";
    int max = 0;

    for(Race race : races) {
      if(max < race.total()) {
        max = race.total();
        winners = race.carName();
      }else if(max == race.total()) {
        winners += ", " + race.carName();
      }
    }

    return winners;
  }
}
