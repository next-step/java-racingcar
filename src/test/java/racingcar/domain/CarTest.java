package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("유효한 자동차 이름들로 Car 인스턴스 생성시, 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345", "holee"})
    void GivenValidCarName_WhenCreateInstance_ThenNotThrowException(String carName) {
        assertDoesNotThrow(() -> new Car(carName));
    }

    @DisplayName("이름을 공백으로하는 Car 인스턴스 생성시, IllegalArgumentException 이 발생한다.")
    @Test
    void GivenBlankCarName_WhenCreateInstance_ThenIllegalArgumentException() {
        final String blank = "";

        assertThatThrownBy(() -> new Car(blank))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름을 5글자 이상으로 Car 인스턴스 생성시, IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "OVER_FIVE_LENGTH"})
    void GivenCarNameLengthOverFive_WhenCreateInstance_ThenIllegalArgumentException(
        String carName) {
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 파라미터로 Car 인스턴스 생성시, 기본 distance는 0 이다.")
    @Test
    void GivenValidParameter_WhenCreateInstance_ThenDistanceIsEqualToZero() {
        final int CAR_DEFAULT_DISTANCE = 0;

        Car car = new Car("A");

        assertThat(car.getDistance())
            .isEqualTo(CAR_DEFAULT_DISTANCE);
    }

    @DisplayName("strategy.isMovable()가 참일때 run 메소드 실행시, distance는 1 증가한다.")
    @Test
    void GivenRunStrategyIsMovable_WhenRun_ThenDistanceIsEqualToOne() {
        final int AFTER_ONE_MOVE_DISTANCE = 1;

        Car car = new Car("A");

        car.run(() -> true);

        assertThat(car.getDistance())
            .isEqualTo(AFTER_ONE_MOVE_DISTANCE);
    }

    private void carMove(Car car, List<Boolean> moves) {
        for (boolean carMoved : moves) {
            car.run(() -> carMoved);
        }
    }

    static Stream<Arguments> generateOneTimeCarMoveParameter() {
        return Stream.of(
            Arguments.of(Arrays.asList(true)),
            Arguments.of(Arrays.asList(true, false)),
            Arguments.of(Arrays.asList(true, false, false)),
            Arguments.of(Arrays.asList(false, true)),
            Arguments.of(Arrays.asList(false, false, true))
        );
    }

    @DisplayName("파라미터로 하나만 참인 불리언 리스트가 주어질때 custom carMove 메소드 실행시, distance는 1 증가한다.")
    @ParameterizedTest
    @MethodSource("generateOneTimeCarMoveParameter")
    void GivenListWithOneTrueBoolean_WhenCustomCarMoveMethod_ThenDistanceIsEqualToOne(
        List<Boolean> moves) {
        final int AFTER_ONE_MOVE_DISTANCE = 1;

        Car car = new Car("A");

        carMove(car, moves);

        assertThat(car.getDistance())
            .isEqualTo(AFTER_ONE_MOVE_DISTANCE);
    }

    static Stream<Arguments> generateThreeTimeCarMoveParameter() {
        return Stream.of(
            Arguments.of(Arrays.asList(true, true, true)),
            Arguments.of(Arrays.asList(true, false, true, false, true)),
            Arguments.of(Arrays.asList(false, false, true, true, true))
        );
    }

    @DisplayName("파라미터로 세개가 참인 불리언 리스트가 주어질때 custom carMove 메소드 실행시, distance는 3 증가한다.")
    @ParameterizedTest
    @MethodSource("generateThreeTimeCarMoveParameter")
    void GivenListWithThreeTrueBoolean_WhenCustomCarMoveMethod_ThenDistanceIsEqualToThree(
        List<Boolean> moves) {
        final int AFTER_Three_MOVE_DISTANCE = 3;

        Car car = new Car("A");

        carMove(car, moves);

        assertThat(car.getDistance())
            .isEqualTo(AFTER_Three_MOVE_DISTANCE);
    }

    @DisplayName("Car 인스턴스 생성후 IsEqualDistance 의 파라미터로 0이 주어질 때, true 가 반환된다.")
    @Test
    void GivenIsEqualDistanceParameterZero_WhenCreateInstanceAndIsEqualDistance_ThenTrue() {
        final int ZERO_DISTANCE = 0;

        assertThat(new Car("A").isEqualDistance(ZERO_DISTANCE))
            .isEqualTo(true);
    }
}
