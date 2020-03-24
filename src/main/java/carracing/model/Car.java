package carracing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class Car {

  public static final Integer INITIAL_POSITION = 1;

  private List<Integer> positions;

  public Car() {
    positions = new ArrayList<>(Arrays.asList(INITIAL_POSITION));
  }

  public List<Integer> getPositions() {
    return positions;
  }

  public void move(BooleanSupplier canMove) {
    Integer nextPosition = positions.get(positions.size() - 1);
    if (canMove.getAsBoolean()) {
      nextPosition++;
    }
    positions.add(nextPosition);
  }
}
