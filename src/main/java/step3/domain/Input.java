package step3.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class Input {

  public static final String DELIMITER = ",";
  private final int numberOfAttempts;
  private final List<Name> names;

  public Input(String names, int numberOfAttempts) {
    this.names = createNames(names);
    validate(numberOfAttempts);
    this.numberOfAttempts = numberOfAttempts;
  }

  private List<Name> createNames(String names) {
    return Arrays.stream(names.split(DELIMITER))
        .map(Name::new)
        .collect(toList());
  }

  private void validate(int numberOfAttempts) {
    if (isNotPositive(numberOfAttempts)) {
      throw new IllegalArgumentException("입력 값은 양의 정수여야 한다");
    }
  }

  private boolean isNotPositive(int numberOfCars) {
    return numberOfCars <= 0;
  }


  public int getNumberOfAttempts() {
    return numberOfAttempts;
  }

  public List<Name> getNames() {
    return names;
  }
}
