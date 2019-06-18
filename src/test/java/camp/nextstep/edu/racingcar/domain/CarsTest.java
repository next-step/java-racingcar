package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest implements CarNamesHelper {

    private CarNames validCarNames;

    @BeforeEach
    void setUp() {
        validCarNames = this.getValidCarNames();
        assertThat(validCarNames.size()).isEqualTo(3);
    }

    @DisplayName("팩터리 메서드를 통해 Cars 객체가 잘 생성되는지")
    @Test
    void constructor() {
        // given
        // when
        final Cars cars = Cars.defaultInstance(validCarNames);
        // then
        assertThat(cars).isNotNull();
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("자동차 이름 목록이 null 일 경우 객체를 생성하면 안됨")
    @Test
    void constructorThrowsIllegalArgumentExceptionWhenCarNamesIsNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.defaultInstance(null));
    }

    @DisplayName("컬렉션의 size를 잘 반환하는지")
    @Test
    void size() {
        // given
        assertThat(validCarNames.size()).isEqualTo(3);
        // when
        final Cars cars = Cars.defaultInstance(validCarNames);
        // then
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("자동차들이 잘 이동되어야함")
    @Test
    void moveCars() {
        // given
        final Cars cars = Cars.defaultInstance(validCarNames);
        cars.stream().forEach(car ->
                assertThat(car.getPosition().value()).isEqualTo(0)
        );
        // when
        final MovingStrategy moveOnlyStrategy = new MoveOnlyStrategy();
        final Cars movedCars = cars.move(moveOnlyStrategy);
        // then
        movedCars.stream().forEach(car ->
                assertThat(car.getPosition().value()).isEqualTo(1)
        );
    }
}