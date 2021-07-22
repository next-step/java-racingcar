package step3;

import java.util.List;
import java.util.stream.Collectors;

public class Result {

  public static final String LOCATION_VIEW_SIGN = "-";
  public static final String NEWLINE = "\n";
  private final List<Integer> locationOfCars;

  public Result(List<Integer> locationOfCars) {
    this.locationOfCars = locationOfCars;
  }

  public String log() {
    return locationOfCars.stream()
        .map(location -> LOCATION_VIEW_SIGN.repeat(location + 1))
        .collect(Collectors.joining(NEWLINE));
  }
}
