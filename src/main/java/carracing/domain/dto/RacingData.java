package carracing.domain.dto;

import carracing.domain.entity.Car;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingData {

  private final String name;
  private final int step;

  public RacingData(String name, int step) {
    this.name = name;
    this.step = step;
  }

  public int getStep() {
    return step;
  }

  public String getName() {
    return name;
  }

  public static RacingData of(Car car) {
    return new RacingData(car.getName(), car.getNowStep());
  }

  public static List<RacingData> of(List<Car> carList) {
    return carList.stream()
                  .map(RacingData::of)
                  .collect(toList());
  }
}
