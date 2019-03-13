package racing.view;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TestInputView extends InputView {

  private int carCount;
  private int moveCount;

  private String carNames;

  private TestInputView(int moveCount) {
    this.moveCount = moveCount;
  }

  public TestInputView(int carCount, int moveCount) {
    this(moveCount);
    this.carCount = carCount;
  }

  public TestInputView(String carNames, int moveCount) {
    this(moveCount);
    this.carNames = carNames;
  }

  @Override
  public int inputCarCount() {

    setSystemIn(carCount + "");
    return super.inputCarCount();
  }

  @Override
  public int inputMoveCount() {

    setSystemIn(moveCount + "");
    return super.inputMoveCount();
  }

  @Override
  public String inputCarNames() {

    setSystemIn(carNames);
    return super.inputCarNames();
  }

  private void setSystemIn(String input) {
    ByteArrayInputStream in = new ByteArrayInputStream(
        (input + "").getBytes(StandardCharsets.UTF_8)
    );
    this.scanner = new Scanner(in);
  }
}
