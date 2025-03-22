package racing.types;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarRacingGameSimulateResult {
  private final List<CarGroup> simulateResult;

  public static CarRacingGameSimulateResult valueOf(List<CarGroup> simulateResult) {
    return new CarRacingGameSimulateResult(simulateResult);
  }

  private CarRacingGameSimulateResult(List<CarGroup> simulateResult) {
    this.simulateResult = simulateResult;
  }

  public CarGroup getLastSimulateResult() {
    return this.simulateResult.get(simulateResult.size() - 1);
  }

  public String toWinnerNamesString() {
    return getLastSimulateResult().toWinnerCarGroup().toNameString();
  }

  public String toSimulationLocationString() {
    return simulateResult.stream()
        .map(CarGroup::toLocationString)
        .collect(Collectors.joining("\n"));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CarRacingGameSimulateResult that = (CarRacingGameSimulateResult) o;
    return Objects.equals(simulateResult, that.simulateResult);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(simulateResult);
  }
}
