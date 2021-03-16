package study1.winner.code.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
  @ParameterizedTest
  @CsvSource(value = {"pobi:1", "tim:2"}, delimiter = ':')
  @DisplayName("자동차 이동시 동일한 운전자, 한칸 증가한 distance 를 가진 자동차가 리턴되는지")
  public void autoTrim(String name, int initDistance) {
    Car car = new Car(name, initDistance);
    car.move(() -> true);

    assertThat(car.equals(new Car(name, initDistance + 1))).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:1:true", "2:1:false"}, delimiter = ':')
  @DisplayName("자동차 이동시 동일한 운전자, 한칸 증가한 distance 를 가진 자동차가 리턴되는지")
  public void isWinner(int maxDistance, int distance, boolean result) {
    final String DIRVER = "tester";
    Car car = new Car(DIRVER, distance);

    assertThat(car.isWinner(maxDistance)).isEqualTo(result);
  }
}
