package carracing.domain.dto;

import carracing.domain.entity.Car;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingData {

  private final int step;

  public RacingData(int step) {
    this.step = step;
  }

  public int getStep() {
    return step;
  }

  public static RacingData of(Car car) {
    return new RacingData(car.getNowStep());
  }

  public static List<RacingData> of(List<Car> carList) {
    return carList.stream()
                  .map(RacingData::of)
                  .collect(toList());
  }
}
