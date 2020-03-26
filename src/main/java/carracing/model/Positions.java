package carracing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Positions {

  public static final int INITIAL_POSITION = 1;
  public static final int MOVED_ONCE = 1;

  private List<Integer> positions;

  public Positions() {
    positions = new ArrayList<>(Arrays.asList(INITIAL_POSITION));
  }

  public Integer getFinalPosition() {
    return positions.get(positions.size() - 1);
  }

  public void move(boolean bool) {
    Integer nextPosition = getFinalPosition();
    if (bool) {
      nextPosition = nextPosition + MOVED_ONCE;
    }
    positions.add(nextPosition);
  }
}
