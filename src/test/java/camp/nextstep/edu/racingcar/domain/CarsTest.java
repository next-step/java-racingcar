package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {
    @DisplayName("팩터리 메서드를 통해 Cars 객체가 잘 생성되는지")
    @Test
    void constructor() {
        final Cars cars = Cars.defaultInstance(3);
        assertThat(cars).isNotNull();
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("size 가 0보다 작은 경우 객체를 생성하면 안됨")
    @Test
    void constructorThrowsIllegalArgumentExceptionWhenSizeIsLessThenZero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.defaultInstance(-1));
    }

    @DisplayName("컬렉션의 size를 잘 반환하는지")
    @Test
    void size() {
        final Cars cars = Cars.defaultInstance(3);
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("자동차들이 잘 이동되어야함")
    @Test
    void moveCars() {
        // given
        final Cars cars = Cars.defaultInstance(3);
        cars.stream().forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
        // when
        final MovingStrategy moveOnlyStrategy = new MoveOnlyStrategy();
        final Cars movedCars = cars.move(moveOnlyStrategy);
        // then
        movedCars.stream().forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
    }
}