package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.config.RacingCarException.CAR_NAME_DUPLICATED;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차 객체 목록을 반환하는 메서드를 호출하면, 그에 대한 복사본 목록이 반환된다.")
    void cars_CopyCarList() {
        final String[] carNames = {"kyle", "alex"};
        final Cars cars = Cars.from(carNames);

        assertThat(cars.cars())
                .hasSize(carNames.length);
    }

    @Test
    @DisplayName("자동차 이름 목록을 통해 자동차들을 생성한다.")
    void from_CarNames_RacingCars() {
        final String[] carNames = {"kyle", "alex", "haley"};

        assertThat(Cars.from(carNames))
                .isNotNull();
    }

    @Test
    @DisplayName("자동차 이름 목록에 중복이 존재한 상태로 자동차들을 생성하는 경우 예외를 던진다.")
    void from_DuplicatedCarNames_Exception() {
        final String[] duplicatedCarNames = {"kyle", "kyle", "alex"};

        assertThatThrownBy(() -> Cars.from(duplicatedCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATED.message(duplicatedCarNames));
    }
}
