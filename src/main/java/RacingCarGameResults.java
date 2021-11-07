import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameResults {

  private List<List<Integer>> resultList;

  public RacingCarGameResults(int chanceAmount) {
    this.resultList = new ArrayList(chanceAmount);
  }

  public void addResult(RacingCars racingCars) {
    List<RacingCar> racingCarList = racingCars.getRacingCarList();
    List<Integer> result = racingCarList.stream()
            .map(RacingCar::getProgress)
            .collect(Collectors.toList());
    resultList.add(result);
  }

  public List<List<Integer>> getResultList() {
    return this.resultList;
  }
}
