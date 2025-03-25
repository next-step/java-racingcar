package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;

public class CarTest {

  @Test
  void getName() {
    Car car = new Car("test");
    assertEquals("test", car.getName());
  }

  @Test
  void tryMove_success() {
    Random testRandom = new Random() {
      @Override
      public int nextInt(int bound) {
        return 4;
      }
    };
    RaceEvaluator raceEvaluator = new RaceEvaluator(testRandom);
    Car car = new Car("test");
    car.tryMove(raceEvaluator);
    car.tryMove(raceEvaluator);
    assertEquals(2, car.getScore());
  }

  @Test
  void tryMove_stay() {
    Random testRandom = new Random() {
      @Override
      public int nextInt(int bound) {
        return 3;
      }
    };
    RaceEvaluator raceEvaluator = new RaceEvaluator(testRandom);
    Car car = new Car("test");
    car.tryMove(raceEvaluator);
    car.tryMove(raceEvaluator);
    assertEquals(0, car.getScore());
  }

  @Test
  void mergeScore() {
    Random testRandom = new Random() {
      @Override
      public int nextInt(int bound) {
        return 4;
      }
    };
    RaceEvaluator raceEvaluator = new RaceEvaluator(testRandom);
    Car car = new Car("test");
    car.tryMove(raceEvaluator);

    car.addScore(3);
    assertEquals(4, car.getScore());
  }

  @Test
  void showPosition() {
    Car car = new Car("test", 3);
    assertEquals("---", car.showPosition("-"));
  }
}
