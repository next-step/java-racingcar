package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.TestRacingCarConfig.basicRule;
import static racingcar.TestRacingCarConfig.moveForwardNumberGenerator;
import static racingcar.TestRacingCarConfig.stopNumberGenerator;
import static racingcar.config.RacingCarException.CAR_NAME_LONGER_THAN_MAXIMUM_LENGTH;
import static racingcar.config.RacingCarException.CAR_NAME_NOT_MATCHES_PATTERN;
import static racingcar.domain.Car.SPEED;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("isSamePosition 메서드에 동일한 위치 값을 넣으면 true를 반환한다.")
    void isSamePosition_SamePosition_True() {
        final Car car = Car.from("kyle");
        final int position = car.position();

        assertThat(car.isSamePosition(position))
                .isTrue();
    }

    @Test
    @DisplayName("isSamePosition 메서드에 동일하지 않은 위치 값을 넣으면 false를 반환한다.")
    void isSamePosition_DifferentPosition_False() {
        final Car car = Car.from("kyle");
        final int position = car.position() + 1;

        assertThat(car.isSamePosition(position))
                .isFalse();
    }

    @Test
    @DisplayName("copyOf 메서드는 내부 필드 값은 같으나, 다른 참조를 가진 복사본을 반환한다.")
    void copyOf() {
        final Car originCar = Car.from("kyle");
        final Car copiedCar = originCar.copyOf();

        assertThat(originCar).isNotSameAs(copiedCar);

        assertThat(originCar.name())
                .isEqualTo(copiedCar.name());
        assertThat(originCar.position())
                .isEqualTo(copiedCar.position());
    }

    @Test
    @DisplayName("자동차는 전진 조건에 해당하면 자동차의 속도만큼 위치를 이동한다.")
    void moveForwardOrStop_MoveForwardCondition_PositionIncrement() {
        final Car car = Car.from("kyle");
        final int expectedPosition = car.position() + SPEED;

        car.moveForwardOrStop(new MovementStrategy(basicRule(), moveForwardNumberGenerator()));

        assertThat(car.position())
                .isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("자동차는 정지 조건에 해당하면 현재 위치를 유지한다.")
    void moveForwardOrStop_StopCondition_PositionMaintain() {
        final Car car = Car.from("kyle");
        final int expectedPosition = car.position();

        car.moveForwardOrStop(new MovementStrategy(basicRule(), stopNumberGenerator()));

        assertThat(car.position())
                .isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "kyle", "123", "ky123"})
    @DisplayName("한 글자 이상의 공백이 없는 영어 소문자와 숫자로 이루어진 이름으로 자동차를 생성한다.")
    void from_CarNameWithLowercaseAndNumber_Car(final String carName) {
        assertThat(Car.from(carName).name())
                .isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {" a", "a ", " a ", "a\n", "\na", "\na\n", "a\n ", "\n a", " a\n"})
    @DisplayName("자동차 이름의 양쪽 끝에 존재하는 공백을 제거한 후 자동차를 생성한다.")
    void from_SpacePaddedCarName_Car(final String carName) {
        assertThat(Car.from(carName).name())
                .isEqualTo(carName.trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "ky le", "$1k", "k 123"})
    @DisplayName("영어 소문자나 숫자 이외의 문자가 포함된 이름으로 자동차를 생성하는 경우 예외를 던진다.")
    void from_CarNameWithSpaceOrSpecialCharacter_Exception(final String invalidCarName) {
        assertThatThrownBy(() -> Car.from(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_NOT_MATCHES_PATTERN.message(invalidCarName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", "\n"})
    @DisplayName("빈 문자열, 공백, 개행으로 자동차를 생성하는 경우 예외를 던진다.")
    void from_BlankCarName_Exception(final String blankCarName) {
        assertThatThrownBy(() -> Car.from(blankCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_NOT_MATCHES_PATTERN.message(""));
    }

    @Test
    @DisplayName("최대 길이를 초과한 이름으로 자동차를 생성하는 경우 예외를 던진다.")
    void from_CarNameLongerThanMaximumLength_Exception() {
        final String longCarName = "kyle12";

        assertThatThrownBy(() -> Car.from(longCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LONGER_THAN_MAXIMUM_LENGTH.message(longCarName));
    }
}
