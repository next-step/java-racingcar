package Racing.type;

import java.util.Objects;
import java.util.stream.Collector;

public class RacingString {

  static private final String DISPLAY_TOKEN = "-";
  static public final RacingString DELIMITER = new RacingString("\n");
  static public final RacingString DISPLAY_TOKEN_STRING = new RacingString(DISPLAY_TOKEN);
  private final String value;

  public RacingString(String input) {
    value = input;
  }

  public RacingString() {
    this("");
  }

  public RacingString(RacingString racingString) {
    this(racingString.value);
  }

  public static Collector<RacingString, RacingString, RacingString> joining() {
    final RacingString[] accumulationRacingString = {new RacingString()};
    return Collector.of(
        () -> accumulationRacingString[0],
        (control, comparison) -> accumulationRacingString[0] = accumulationRacingString[0]
            .concat(control)
            .concat(comparison),
        (control, comparison) -> accumulationRacingString[0].concat(comparison),
        control -> new RacingString(accumulationRacingString[0])

    );
  }

  public static Collector<RacingString, ?, RacingString> joining(
      RacingString delimiter) {
    final RacingString[] accumulationRacingString = {new RacingString()};
    return Collector.of(
        () -> accumulationRacingString[0],
        (control, comparison) -> accumulationRacingString[0] = getAccmulationRacingString(
            accumulationRacingString[0], control, comparison, delimiter),
        (control, comparison) -> accumulationRacingString[0].concat(control).concat(delimiter)
            .concat(comparison),
        racingString -> new RacingString(accumulationRacingString[0])

    );
  }

  private static RacingString getAccmulationRacingString(
      RacingString accumulationRacingString,
      RacingString control,
      RacingString comparison,
      RacingString delimiter
  ) {
    if (accumulationRacingString.equals(new RacingString())) {
      return accumulationRacingString.concat(comparison);
    }
    return accumulationRacingString.concat(control).concat(delimiter).concat(comparison);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RacingString that = (RacingString) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  public RacingString repeat(RacingNumber times) {
    String accumlulate = "";
    for (int i = 0; i < times.parseInt(); i++) {
      accumlulate += this.value;
    }
    return new RacingString(accumlulate);
  }

  public RacingString concat(RacingString input) {
    return new RacingString(this.value + input.value);
  }

  @Override
  public String toString() {
    return value;
  }
}
