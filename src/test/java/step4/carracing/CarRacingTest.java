package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarRacingTest {
  private static final Set<Integer> VALID_RANDOM_NUMBERS = new HashSet<>(Arrays.asList(
          0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

  @DisplayName("0-9 사이 랜덤으로 자동차 이동 전략을 구하는 테스트")
  @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
  void testGetMoveSteps() {
    int actual = new RandomCarMoveStrategy().getMoveSteps();
    assertTrue(VALID_RANDOM_NUMBERS.contains(actual));
  }

  @DisplayName("자동차가 4 이상일때 움직이는 테스트")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  void testMove(int number) {
    Car car = new Car("test");
    int currentPosition = car.getPosition();

    car.move(number);

    assertEquals(currentPosition + 1, car.getPosition());
  }

  @DisplayName("자동차가 4 미만일때 움직이는 테스트")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void testNotMove(int number) {
    Car car = new Car("test");
    int currentPosition = car.getPosition();

    car.move(number);

    assertEquals(currentPosition, car.getPosition());
  }

  @DisplayName("자동차 이름 리스트를 입력받는 기능 테스트")
  @Test
  void testGetCarNameListInput() {
    List<String> expected = List.of("pobi", "crong", "honux");
    Scanner testScanner = new Scanner("pobi, crong, honux" + "\n");
    InputView inputView = new InputView(testScanner);

    List<String> actual = inputView.receiveCarNames();

    assertEquals(expected, actual);
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

    Assertions.assertThrows(InputMismatchException.class, inputView::receiveTryCount);
  }

  @DisplayName("매 회마다 자동차들의 위치를 출력하는 기능 테스트")
  @Test
  void testPrintCarPosition() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    Car car = new Car("pobi");
    car.move(4);
    car.move(4);
    car.move(1);
    String expected = "pobi : " + "---\n";

    ResultView.printCarStatus(car);

    System.setOut(originalOut);
    Assertions.assertEquals(expected, outputStream.toString());
  }

}
