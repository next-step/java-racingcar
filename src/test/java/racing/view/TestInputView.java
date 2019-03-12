package racing.view;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TestInputView extends InputView {

  private int carCount;
  private int moveCount;

  public TestInputView(int carCount, int moveCount) {
    this.carCount = carCount;
    this.moveCount = moveCount;
  }

  @Override
  public int inputCarCount() {

    setSystemIn(carCount);
    return super.inputCarCount();
  }

  @Override
  public int inputMoveCount() {

    setSystemIn(moveCount);
    return super.inputMoveCount();
  }

  private void setSystemIn(int inputCount) {
    ByteArrayInputStream in = new ByteArrayInputStream(
        (inputCount + "").getBytes(StandardCharsets.UTF_8)
    );
    this.scanner = new Scanner(in);
  }
}
