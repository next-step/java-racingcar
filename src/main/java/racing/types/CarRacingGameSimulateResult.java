package racing.types;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGameSimulateResult {
  private final List<List<Car>> simulateResult;

  public static CarRacingGameSimulateResult valueOf(List<List<Car>> simulateResult) {
    return new CarRacingGameSimulateResult(simulateResult);
  }

  private CarRacingGameSimulateResult(List<List<Car>> simulateResult) {
    if (simulateResult.stream().anyMatch(List::isEmpty)) {
      throw new IllegalArgumentException("시뮬레이션 각 라운드 결과에서 빈 결과가 들어갈 수 없습니다.");
    }

    this.simulateResult = simulateResult;
  }

  public List<List<Car>> getSimulationResult() {
    return this.simulateResult;
  }

  public List<Car> getWinner() {
    List<Car> lastSimulateResult = this.simulateResult.get(this.simulateResult.size() - 1);
    ;

    if (lastSimulateResult.isEmpty()) {
      return Collections.emptyList();
    }

    int maxLocation = lastSimulateResult.stream()
        .mapToInt(Car::getLocation)
        .max()
        .orElse(0);

    return lastSimulateResult.stream()
        .filter(car -> car.getLocation() == maxLocation)
        .collect(Collectors.toList());
  }
}
