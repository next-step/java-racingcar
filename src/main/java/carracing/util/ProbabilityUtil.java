package carracing.util;

import java.util.Random;
import java.util.function.BooleanSupplier;

public class ProbabilityUtil {

  private static final int RANDOM_RANGE = 10;
  private static final int MOVE_CRITERION = 3;

  public static BooleanSupplier HUNDRED_PRECENT = () -> true;
  public static BooleanSupplier ZERO_PERCENT = () -> false;
  public static BooleanSupplier FOURTY_PERCENT =
      () -> new Random().nextInt(RANDOM_RANGE) > MOVE_CRITERION;
}
