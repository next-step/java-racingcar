package base;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Random;
import java.util.stream.Stream;

public class BaseMethodSource {

  private final static String CLASS_NAME_WITH_PACKAGE_PATH = "base.BaseMethodSource";
  public final static String RANDOM_NUMBER_BELOW_10 = CLASS_NAME_WITH_PACKAGE_PATH + "#getRandomNumberBelow10";
  public final static String PLAY_INFO_ARGUMENTS = CLASS_NAME_WITH_PACKAGE_PATH + "#getRacingCarGamePlayInfoArguments";

  private BaseMethodSource() {
  }

  static Stream<Integer> getRandomNumberBelow10() {
    return Stream.of(new Random().nextInt(10));
  }

  static Stream<Arguments> getRacingCarGamePlayInfoArguments() {
    return Stream.of(
            Arguments.of(2, 3),
            Arguments.of(3, 2)
    );
  }
}

