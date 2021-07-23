package step3;

import java.util.List;
import java.util.stream.Collectors;

public class Result {

  private static final String LOCATION_VIEW_SIGN = "-";
  private static final String NEWLINE = System.lineSeparator();
  private final List<Integer> locationOfCars;

  public Result(List<Integer> locationOfCars) {
    this.locationOfCars = locationOfCars;
  }

  public String log() {
    return locationOfCars.stream()
        .map(LOCATION_VIEW_SIGN::repeat)
        .collect(Collectors.joining(NEWLINE));
  }
}
