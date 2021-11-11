import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCarGameResults {

  private Map<Integer, List<RacingCarResult>> results;
  private List<String> winnerNames;

  public RacingCarGameResults(int roundAmount) {
    this.results = new HashMap(roundAmount);
  }

  public void addResult(int round, RacingCars racingCars) {
    List<RacingCar> racingCarList = racingCars.getRacingCars();
    List<RacingCarResult> roundResult = racingCarList.stream()
            .map(RacingCarResult::new)
            .collect(Collectors.toList());
    results.put(round, roundResult);
  }

  public void setWinnerNames(RacingCars racingCars) {
    Integer maxProgress = getMaxProgress(racingCars);
    this.winnerNames = getWinnerNames(racingCars, maxProgress);
  }

  private int getMaxProgress(RacingCars racingCars) {
    return racingCars.getRacingCars().stream()
            .mapToInt(RacingCar::getProgress)
            .max()
            .orElse(0);
  }

  private List<String> getWinnerNames(RacingCars racingCars, Integer maxProgress) {
        return racingCars.getRacingCars().stream()
            .filter(racingCar -> racingCar.equalsProgress(maxProgress))
            .map(RacingCar::getName)
            .collect(Collectors.toList());
  }


  public Map<Integer, List<RacingCarResult>> getResults() {
    return this.results;
  }

  public List<String> getWinnerNames() {
    return this.winnerNames;
  }

  public void setWinnerNames(RacingCars racingCars) {
    this.winnerNames = racingCars.findWinnerNames();
  }

}
