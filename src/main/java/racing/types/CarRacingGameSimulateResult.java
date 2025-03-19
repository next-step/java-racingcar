package racing.types;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarRacingGameSimulateResult {
  private final List<List<Car>> simulationResult;

  public CarRacingGameSimulateResult(List<List<Car>> simulationResult) {
    if (simulationResult == null) {
      throw new IllegalArgumentException("시뮬레이션 결과는 null이 들어갈 수 없습니다.");
    }
    if (simulationResult.stream().anyMatch(Objects::isNull)) {
      throw new IllegalArgumentException("시뮬레이션 각 라운드 결과에서 null이 들어갈 수 없습니다.");
    }
    if (simulationResult.stream().anyMatch(List::isEmpty)) {
      throw new IllegalArgumentException("시뮬레이션 각 라운드 결과에서 빈 결과가 들어갈 수 없습니다.");
    }

    this.simulationResult = simulationResult;
  }

  public List<List<Car>> getSimulationResult() {
    return this.simulationResult;
  }

  public List<Car> getWinner() {
    List<Car> lastSimulateResult = getLastSimulateResult();

    if (lastSimulateResult.isEmpty()) {
      return new ArrayList<>();
    }

    int maxLocation = lastSimulateResult.stream()
        .max(Comparator.comparingInt(Car::getLocation))
        .get()
        .getLocation();

    return lastSimulateResult.stream()
        .filter(car -> car.getLocation() == maxLocation)
        .collect(Collectors.toList());
  }

  private List<Car> getLastSimulateResult() {
    return this.simulationResult.get(this.simulationResult.size() - 1);
  }
}
