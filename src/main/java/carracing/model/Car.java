package carracing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Car {

  private static final Integer RANDOM_RANGE = 10;
  private static final Integer MOVE_CRITERION = 3;
  public static final Integer INITIAL_POSITION = 1;

  private List<Integer> positions;

  public Car() {
    positions = new ArrayList<>(Arrays.asList(INITIAL_POSITION));
  }

  public List<Integer> getPositions() {
    return positions;
  }

  public void move() {
    moveIf(canMove());
  }

  public void moveIf(boolean canMove) {
    Integer nextPosition = positions.get(positions.size() - 1);
    if (canMove) {
      nextPosition++;
    }
    positions.add(nextPosition);
  }

  private boolean canMove() {
    return new Random().nextInt(RANDOM_RANGE) > MOVE_CRITERION;
  }
}
