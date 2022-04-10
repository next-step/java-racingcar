package racing.object;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.strategy.RandomMoveStrategy;

class CarTest {

  @Test
  @DisplayName("앞으로 1회 이동했을 때 이동 거리 확인")
  void oneMoveTest() {
    Car car = new Car();
    car.move();

    assertEquals(car.getDistance(), 1);
  }

  @ParameterizedTest
  @DisplayName("앞으로 n회 이동했을 때 이동 거리 확인")
  @CsvSource(value = {"1|1", "2|2", "0|0", "10|10", "100|100"}, delimiter = '|')
  void nMoveTest(int n, int expected) {
    Car car = new Car();
    for (int i = 0; i < n; i++) {
      car.move();
    }

    assertEquals(car.getDistance(), expected);
  }

  @ParameterizedTest
  @DisplayName("시도 갯수를 받아 따라 랜덤하게 n회 시도했을 때 이동 거리 확인")
  @ValueSource(ints = {1, 10, 50, 10000})
  void randomMoveTest(int attempt) {
    RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
    Car car = new Car();
    car.setMoveStrategy(randomMoveStrategy);
    int distanceExpected = 0;

    for (int i = 0; i < attempt; i++) {
      car.attempt();
      if (randomMoveStrategy.isLastMove()) {
        distanceExpected++;
      }
    }

    assertEquals(car.getDistance(), distanceExpected);
  }

  @ParameterizedTest
  @DisplayName("차량 갯수와 시도 갯수를 받아 따라 랜덤하게 n회 시도했을 때 이동 거리 확인")
  @CsvSource(value = {"1|1", "100|100", "52|52", "0|0"}, delimiter = '|')
  void randomCarMoveTest(int carCount, int attempt) {
    RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
    Car[] cars = new Car[carCount];
    int[] distancesReal = new int[carCount];
    int[] distancesExcepted = new int[carCount];

    for (int i = 0; i < carCount; i++) {
      cars[i] = new Car(randomMoveStrategy);
    }

    for (int i = 0; i < cars.length; i++) {
      for (int j = 0; j < attempt; j++) {
        cars[i].attempt();
        if (randomMoveStrategy.isLastMove()) {
          distancesExcepted[i]++;
        }
      }
    }

    for (int i = 0; i < cars.length; i++) {
      distancesReal[i] = cars[i].getDistance();
    }

    assertArrayEquals(distancesReal, distancesExcepted);
  }

}