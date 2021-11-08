import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

  private static final int MAX = 10;
  private static final int FORWARD_THRESHOLD = 4;

  @Override
  public boolean isMovable() {
    Random random = new Random();
    int randomValue = random.nextInt(MAX);
    return randomValue >= FORWARD_THRESHOLD;
  }

}
