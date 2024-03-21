package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.car.Car.SPEED;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.TestRacingCarConfig;
import racingcar.domain.movement.MovementStrategy;

class CarTest {

    private static MovementStrategy basicMoveForwardStrategy;
    private static MovementStrategy basicStopStrategy;

    @BeforeAll
    static void setUp() {
        basicMoveForwardStrategy = TestRacingCarConfig.basicMoveForwardStrategy();
        basicStopStrategy = TestRacingCarConfig.basicStopStrategy();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,2,false"})
    @DisplayName("자동차의 위치 값을 기준으로 특정 위치에 있는지 여부를 판단한다.")
    void equalsPosition_Position_TrueOrFalse(
            final int originPositionValue,
            final int targetPositionValue,
            final boolean isEqualPosition
    ) {
        final Car car = new Car("kyle", originPositionValue);
        final Position position = new Position(targetPositionValue);

        assertThat(car.equalsPosition(position))
                .isEqualTo(isEqualPosition);
    }

    @Test
    @DisplayName("자동차는 전진 조건에 해당하면 자동차의 속도만큼 위치를 이동한다.")
    void moveForwardOrStop_MoveForwardCondition_PlusPosition() {
        final int startPositionValue = 0;
        final Car car = new Car("kyle", startPositionValue);
        final Position expectedPosition = new Position(startPositionValue + SPEED);

        car.moveForwardOrStop(basicMoveForwardStrategy);

        assertThat(car.equalsPosition(expectedPosition))
                .isTrue();
    }

    @Test
    @DisplayName("자동차는 정지 조건에 해당하면 현재 위치를 유지한다.")
    void moveForwardOrStop_StopCondition_MaintainPosition() {
        final int startPositionValue = 0;
        final Car car = new Car("kyle", startPositionValue);
        final Position expectedPosition = new Position(startPositionValue);

        car.moveForwardOrStop(basicStopStrategy);

        assertThat(car.equalsPosition(expectedPosition))
                .isTrue();
    }

    @Test
    @DisplayName("자동차 객체 복사 시 참조 값이 다른 동등한 객체를 생성한다.")
    void copyOf_SameNameAndPosition_Car() {
        final Car originCar = new Car("kyle", 1);
        final Car copiedCar = originCar.copyOf();

        assertThat(originCar)
                .isNotSameAs(copiedCar)
                .isEqualTo(copiedCar);
    }

    @ParameterizedTest
    @CsvSource(value = {"kyle,1,kyle,1,true", "kyle,1,alex,1,false", "kyle,1,kyle,2,false", "kyle,1,alex,2,false"})
    @DisplayName("이름 문자열 리터럴을 기준으로 동등성을 판단한다.")
    void equals_NameAndPosition_TrueOrFalse(
            final String originNameValue,
            final int originPositionValue,
            final String targetNameValue,
            final int targetPositionValue,
            final boolean isEqualCar
    ) {
        final Car originCar = new Car(originNameValue, originPositionValue);
        final Car targetCar = new Car(targetNameValue, targetPositionValue);

        assertThat(originCar.equals(targetCar))
                .isEqualTo(isEqualCar);
    }
}
