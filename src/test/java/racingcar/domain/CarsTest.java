package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {

  public static final List<String> WINNERS_NAME = List.of("pobi");
  private static final List<Car> CARS = List.of(
          new Car("pobi", new Position(2)),
          new Car("jason",new Position(1)),
          new Car("jobi", new Position(0))
  );

  @DisplayName("유효한 값으로 Cars 인스턴스가 올바르게 생성된다")
  @Test
  void create() {
    Cars cars = new Cars(CARS);
    assertThat(cars).isNotNull();
  }

  @DisplayName("사용자 입력값 만큼의 자동차를 생성할 수 있다")
  @Test
  void carSize() {
    Cars cars = new Cars(CARS);
    assertThat(cars.getCars().size()).isEqualTo(3);
  }

  @DisplayName("경주를 진행했을 때, 현재 위치가 가장 먼 자동차들의 이름을 우승자로 잘 반환하는지 검증")
  @Test
  void getWinners() {
    Cars cars = new Cars(CARS);
    cars.moveCars(() -> true);
    List<String> winnersName = cars.getWinnersName();

    assertThat(winnersName).isEqualTo(WINNERS_NAME);
  }
}
