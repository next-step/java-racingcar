package study.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

  @ParameterizedTest
  @CsvSource({"1,1", "2,2", "3,3"})
  void 입력값만큼차량생성(int input, int expected) {
    Cars cars = new Cars(input);
    assertThat(cars.getCars().size()).isEqualTo(expected);
  }

  @DisplayName("N개의 자동차를 랜덤한 거리만큼 각각 이동하게하여 생성 테스트.")
  @ParameterizedTest
  @ValueSource(ints = {10})
  void 랜덤거리주행자동차여러개생성(int count) {
    Cars cars = new Cars(count);
    assertThat(cars.getCars().size()).isEqualTo(10);
  }

  @DisplayName("이름, 수량을 기입한 만큼 차객체 생성 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"test1,test2,test3:3"}, delimiter = ':')
  void 이름및수량만큼차량생성(String carsName, int expected) {
    Cars cars = new Cars(carsName);
    String[] result = {"test1", "test2", "test3"};
    assertThat(cars.getCars().size()).isEqualTo(expected);
    assertThat(cars.getCars()).extracting(car -> car.getName().getCarName())
        .containsExactly(result);
  }

  @DisplayName("차량 객체를 생성해서 주행거리가 비교값보다 큰지 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"test1,5,0", "test1,7,0"})
  void 차량생성및주행거리비교테스트(String name, int randomValue, int target) {
    Cars cars = new Cars(name);

    for (Car car : cars.getCars()) {
      car.moveTheCar(randomValue);
    }

    assertThat(cars.getMaxMoveDistance()).isGreaterThan(target);
  }

  @DisplayName("우승자를 알아내기 위해 경주완료시 최대값 가져오기 테스트.")
  @Test
  void 경주최종거리비교() {

    Cars cars = new Cars("a,b,c");
    int randomValue = 6;
    String winner = "b";
    
    for (Car car : cars.getCars()) {
      movingCarForWinner(randomValue, car, winner);
    }

    assertThat(cars.getWinners()).extracting(car -> car.getName().getCarName()).containsExactly("b");
  }

  private void movingCarForWinner(int randomValue, Car car, String winner) {
    if(winner.equals(car.getName().getCarName())){
      car.moveTheCar(randomValue);
    }
  }

  @DisplayName("우승자 이름 가져오기 테스트.")
  @Test
  void 경주승링자이름알기() {

    Cars cars = new Cars("a,b,c");
    int randomValue = 6;
    String winner = "b";

    for (Car car : cars.getCars()) {
      movingCarForWinner(randomValue, car, winner);
    }

    assertThat(cars.getWinners()).extracting(car -> car.getName().getCarName()).containsExactly("b");
  }
}