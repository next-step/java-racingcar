package step4.carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.carracing.RandomCarMoveStrategy;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

  @DisplayName("자동차 목록 중에서 최대 위치를 구하는 기능 테스트")
  @Test
  void testCompareMaxPositionPosition() {
    Cars cars = new Cars(
            List.of(
                    new Car(1, "pobi", new RandomCarMoveStrategy()),
                    new Car(2, "crong", new RandomCarMoveStrategy()),
                    new Car(3, "honux", new RandomCarMoveStrategy())
            )
    );

    int maxPosition = cars.getMaxPosition();

    assertEquals(3, maxPosition);
  }

  @DisplayName("자동차 목록 중에서 특정 위치에 있는 자동차들을 필터링하는 기능 테스트")
  @Test
  void testFilterCarsWithCertainPosition() {
    Cars cars = new Cars(
            List.of(
                    new Car(1, "pobi", new RandomCarMoveStrategy()),
                    new Car(2, "crong", new RandomCarMoveStrategy()),
                    new Car(3, "honux", new RandomCarMoveStrategy())
            )
    );

    Cars filteredCars = cars.filterCarsWithCertainPosition(2);

    assertEquals(1, filteredCars.stream().count());
  }

  @DisplayName("자동차 목록의 크기를 구하는 기능 테스트")
  @Test
  void testSize() {
    Cars cars = new Cars(
            List.of(
                    new Car("pobi", new RandomCarMoveStrategy()),
                    new Car("crong", new RandomCarMoveStrategy())
            )
    );

    assertEquals(2, cars.stream().count());
  }

  @DisplayName("중복된 이름의 자동차가 존재 시 예외를 발생시키는 테스트")
  @Test
  void testValidate() {
    assertThatThrownBy(() -> new Cars(
            List.of(
                    new Car("pobi", new RandomCarMoveStrategy()),
                    new Car("pobi", new RandomCarMoveStrategy())
            )
    )).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복된 이름의 자동차가 존재합니다.");
  }

  @DisplayName("자동차 목록이 비어있을 때 예외를 발생시키는 테스트")
  @Test
  void testValidateWithEmptyCars() {
    assertThatThrownBy(() -> new Cars(List.of()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차가 없습니다.");
  }
}