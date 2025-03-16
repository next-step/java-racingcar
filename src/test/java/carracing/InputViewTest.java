package carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {

  @DisplayName("자동차 대수를 입력받는 기능 테스트")
  @Test
  void testGetCarCountInput() {
    int expected = 7;
    Scanner testScanner = new Scanner(expected + "\n");
    InputView inputView = new InputView(testScanner);

    int actual = inputView.receiveCarCount();
    Assertions.assertEquals(expected, actual);
  }

  @DisplayName("이동 횟수를 입력받는 기능 테스트")
  @Test
  void testGetTryCountInput() {
    int expected = 5;
    Scanner testScanner = new Scanner(expected + "\n");
    InputView inputView = new InputView(testScanner);

    int actual = inputView.receiveTryCount();
    assertEquals(expected, actual);
  }

  @DisplayName("숫자가 아닌 입력을 받았을 때 예외를 던지는 기능 테스트")
  @Test
  void testGetInvalidInput() {
    Scanner testScanner = new Scanner("invalid input\n");
    InputView inputView = new InputView(testScanner);

    Assertions.assertThrows(InputMismatchException.class, inputView::receiveCarCount);
  }
}