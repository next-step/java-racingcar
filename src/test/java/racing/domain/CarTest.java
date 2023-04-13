package racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CarTest {

  @Test
  void 자동차_이름_초기화() {
    Car car = new Car("pobi");

    assertThat(car.name()).isEqualTo("pobi");
  }

  @Test
  void 이름_5자_초과시_예외처리() {
    assertThatThrownBy(() -> new Car("pobi123"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
  }

  @Test
  void 자동차_움직이는_경우() {
    MoveStrategy alwaysMoveStrategy = () -> true;
    Car car = new Car("pobi");
    car.move(alwaysMoveStrategy);

    assertThat(car.position()).isEqualTo(1);
  }

  @Test
  void 자동차_움직이지_않는_경우() {
    MoveStrategy alwaysMoveStrategy = () -> false;
    Car car = new Car("pobi");
    car.move(alwaysMoveStrategy);

    assertThat(car.position()).isEqualTo(0);
  }

  @Test
  void 자동차_이름_비교() {
    Car car1 = new Car("pobi");
    Car car2 = new Car("crong");

    assertThat(car1).isEqualTo(car1);
    assertThat(car1).isNotEqualTo(car2);
  }


}