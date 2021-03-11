package study.racing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ResultViewTest {

  @Test
  void positionToString() {
    String printResult = ResultView.positionToString(3);
    assertEquals(printResult, "___");
  }
}
