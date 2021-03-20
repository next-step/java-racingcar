package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.model.Car;
import step4.model.CarFactory;
import step4.model.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {
  @ParameterizedTest
  @CsvSource(value = {"poa,pob,poc,pod"}, delimiter = ':')
  @DisplayName("정상적인 이름으로 생성되는지 확인")
  void makingNameCheckTest(String carNames) {
    Cars cars = CarFactory.makeCars(carNames);

    String[] carsNameArr = cars.getCars().stream().map(Car::showCarName).toArray(String[]::new);
    String[] providedCarNameArr = carNames.split(",");

    assertThat(carsNameArr).containsAll(Arrays.asList(providedCarNameArr.clone()));
  }

  @ParameterizedTest
  @CsvSource(value = {"poa,pob,poc,pod:4"}, delimiter = ':')
  @DisplayName("정상적인 이름 & 대수가 생성되는지 확인")
  void makingTest(String carNames, int count) {
    assertThat(CarFactory.makeCars(carNames).getCars().size()).isEqualTo(count);
  }
}
