package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racingcar.strategy.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Nested
    @DisplayName("Movable 메서드 검증")
    class MoveableValidationTest {
        public static final int lowerBoundNum = NumberGenerator.MOVABLE_LOWER_BOUND;

        @DisplayName("차가 움직일 수 없는 경우 false를 반환한다")
        @ParameterizedTest(name = "{0}을 넣었을때 false를 반환한다")
        @ValueSource(ints = {lowerBoundNum - 1, lowerBoundNum - 2, lowerBoundNum - 3, lowerBoundNum - 4})
        void when_NumberUnderLowerBound_Expects_False(int num) {
            // given, when
            boolean actualResult = Car.isMovable(() -> num);

            // then
            assertThat(actualResult).isFalse();
        }

        @DisplayName("Moveable 할 경우 true를 반환한다.")
        @ParameterizedTest(name = "{0}을 넣었을때 true를 반환한다")
        @ValueSource(ints = {lowerBoundNum, lowerBoundNum + 1, lowerBoundNum + 2, lowerBoundNum + 3})
        void when_NumberIsEqualToOrOverLowerBound_Expects_True(int num) {
            // given, when
            boolean actualResult = Car.isMovable(() -> num);

            // then
            assertThat(actualResult).isTrue();
        }
    }

    @DisplayName("올바른 자동차 이름을 가져오는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"foo", "bar", "baz"})
    void given_CarName_When_CallingGetCarNameMethod_Then_ReturnsEqualCarName(String CarName) {
        // given
        Car car = new Car(CarName);

        // when
        String actualCarName = car.getCarName();

        //then
        assertThat(actualCarName).isEqualTo(CarName);
    }

    @DisplayName("올바른 위치 값을 가지고 오는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void given_CarPosition_When_CallingGetPositionMethod_Then_ReturnsEqualPosition(int expectedPosition) {
        // given
        Car car = new Car("Foo", expectedPosition);

        // when
        int actualPosition = car.getPosition();

        //then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("한번 움직이면 position이 0이다.")
    @Test
    void when_CarDoesNotMove_Expects_PositionZero() {

        // given
        String carName = "foo";
        Car car = new Car(carName);

        // when

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("한번 움직이면 position이 1이다.")
    @Test
    void when_CarMoveOnce_Expects_PositionOne() {
        // given
        String carName = "foo";
        Car car = new Car(carName);

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("한번 움직이면 position이 2이다.")
    @Test
    void when_CarMoveTwice_Expects_PositionTwo() {
        // given
        String carName = "foo";
        Car car = new Car(carName);

        // when
        car.move();
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(2);
    }
}