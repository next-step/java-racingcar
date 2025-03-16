package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarRaceTest {
  private static final Set<Integer> VALID_RANDOM_NUMBERS = new HashSet<>(Arrays.asList(
          0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

  @DisplayName("0-9 사이 랜덤 숫자 생성 테스트")
  @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
  void testGenerateRandomNumber() {
    int actual = RandomNumberGenerator.generate();
     assertTrue(VALID_RANDOM_NUMBERS.contains(actual));
  }

  @DisplayName("자동차 대수를 입력받는 기능 테스트")
  @Test
  void testGetCarCountInput() {
    int expected = 7;
    Scanner testScanner = new Scanner(expected + "\n");
    InputView inputView = new InputView(testScanner);

    int actual = inputView.receiveCarCount();
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

  @DisplayName("4 이상의 숫자일 때 자동차가 이동하는지를 테스트한다.")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  void testCarMove(int number) {
    Car testCar = new Car();
    int currentPosition = testCar.getPosition();

    testCar.move(number);

    assertEquals(currentPosition+1, testCar.getPosition());
  }

  @DisplayName("4 미만의 숫자일 때 자동차가 이동하지 않는지를 테스트한다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void testCarDoNotMove(int number) {
    Car testCar = new Car();
    int currentPosition = testCar.getPosition();

    testCar.move(number);

    assertEquals(currentPosition, testCar.getPosition());
  }

  @DisplayName("자동차의 상태를 출력하는 기능 테스트")
  @Test
  void testPrintCarStatus() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    Car testCar = new Car();
    testCar.move(4);
    testCar.move(5);
    testCar.move(3);
    ResultView.printCarStatus(testCar);

    System.setOut(originalOut);
    String expectedOutput = "---\n";
    assertEquals(expectedOutput, outputStream.toString());
  }
}
