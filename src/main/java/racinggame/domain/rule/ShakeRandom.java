package racinggame.domain.rule;

import java.util.Random;

public class ShakeRandom {

  private final int shakeBound;

  private Random shakeTool = new Random();

  public ShakeRandom(int shakeBound) {
    this.shakeBound = shakeBound;
  }

  public int shakeShake() {
    return shakeTool.nextInt(shakeBound);
  }
}
