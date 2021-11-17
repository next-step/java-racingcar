package carracing.domain;

import carracing.domain.entity.Car;
import carracing.domain.entity.Cars;
import carracing.domain.entity.Name;
import carracing.domain.entity.Number;
import carracing.domain.entity.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

  private static final int SIZE = 3;
  private static final String NAMES = "matt,pobbi,sup";
  private static final String COMMA = ",";
  private Cars cars;

  @BeforeEach
  void setUp() {
    cars = new Cars();
    for (int i = 0; i < SIZE; i++) {
      String[] split = NAMES.split(COMMA);
      Name name = new Name(split[i]);
      cars.register(new Car(name));
    }
  }

  BooleanSupplier isMoved(int a) {
    return () -> a > 3;
  }

  @ParameterizedTest
  @CsvSource(value = {"1:1", "4:2", "10:2"}, delimiter = ':')
  void startRoundTest(int input, int result) {
    cars.notifyCarOfStart(isMoved(input));
    for (Car car: cars.getCarList()) {
        assertThat(car.getNowStep()).isEqualTo(result);
    }
  }

  @ParameterizedTest
  @MethodSource("makeWinner")
  @DisplayName("차의 목록을 받아 그 중 가장 많이 전진한 차들을 반환한다.")
  void getWinnerTest(List<Car> carList, String name) {
    Cars cars = new Cars(carList);
    for (Car car : cars.getWinner().getCarList()) {
      assertThat(car.getName()).isEqualTo(name);
    }
  }

  static Stream<Arguments> makeWinner() {
    List<Car> cars = Arrays.asList(
            new Car(new Name("kevin"), new Step(new Number(2))),
            new Car(new Name("poo")),
            new Car(new Name("bar")));

    List<Car> carList = Arrays.asList(
            new Car(new Name("duke")),
            new Car(new Name("bbit")),
            new Car(new Name("tune"), new Step(new Number(2))));

    return Stream.of(
            Arguments.of(cars, cars.get(0).getName()),
            Arguments.of(carList, carList.get(2).getName()));
  }


}