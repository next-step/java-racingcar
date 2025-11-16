package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * car 파싱
 * */
public class Cars {
  private static final String DELIMITER = ",";
  public static List<Car> from(String names) {
    return Arrays.stream(names.split(DELIMITER))
        .map(String::trim)
        .map(Car::new)
        .collect(Collectors.toList());
  }
}