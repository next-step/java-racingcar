package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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

}
