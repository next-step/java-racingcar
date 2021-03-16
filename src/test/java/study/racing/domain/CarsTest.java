package study.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racing.Racing;

public class CarsTest {

  private Cars cars;

  @BeforeEach
  void dummy() {
    Car car1 = new Car("bong", 3);
    Car car2 = new Car("dong", 0);
    Car car3 = new Car("jung", 3);
    cars = new Cars();
    cars.addAll(car1, car2, car3);
  }

  @Test
  @DisplayName("count 만큼 차를 생성한다.")
  void createCars() {
    String[] names = {"bong", "jung", "dong"};
    Cars cars = Racing.createCars(names);
    assertThat(cars.getCarListForPrint())
        .containsExactly(new Car("bong"), new Car("jung"), new Car("dong"));
  }

  @Test
  @DisplayName("우승자의 position 을 구한다.")
  void getMaxPosition() {
    int winnerPosition = cars.getWinnerPosition();
    assertEquals(winnerPosition, 3);
  }

  @Test
  @DisplayName("우승자 구하기")
  void getWinnerNames() {
    List<String> winnerNames = cars.getWinnerNames();
    assertThat(winnerNames).containsExactly("bong", "jung");
  }

}
