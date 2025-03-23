package step4.carracing.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputViewTest {

  @DisplayName("자동차 이름 리스트를 입력받는 기능 테스트")
  @Test
  void testGetCarNameListInput() {
    List<String> expected = List.of("pobi", "crong", "honux");
    Scanner testScanner = new Scanner("pobi, crong, honux" + "\n");
    InputView inputView = new InputView(testScanner);

    List<String> actual = inputView.receiveCarNames();

    Assertions.assertEquals(expected, actual);
  }

  @DisplayName("이동 횟수를 입력받는 기능 테스트")
  @Test
  void testGetTryCountInput() {
    int expected = 5;
    Scanner testScanner = new Scanner(expected + "\n");
    InputView inputView = new InputView(testScanner);

    int actual = inputView.receiveTryCount();
    Assertions.assertEquals(expected, actual);
  }

  @DisplayName("숫자가 아닌 입력을 받았을 때 예외를 던지는 기능 테스트")
  @Test
  void testGetInvalidInput() {
    Scanner testScanner = new Scanner("invalid input\n");
    InputView inputView = new InputView(testScanner);

    Assertions.assertThrows(InputMismatchException.class, inputView::receiveTryCount);
  }
}