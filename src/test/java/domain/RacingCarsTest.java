package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("레이싱 게임 참여 자동차들 관련")
class RacingCarsTest {

    @DisplayName("참여한 자동차가 없으면 예외 처리를 한다.")
    @Test
    void error_cars_create() {

        assertThatThrownBy(() -> RacingCars.from("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 1 이상이어야 합니다.");
    }

    @DisplayName("자동차 참여 입력의 문자가 포함된 경우 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"d1", "te"})
    void error_cars_create2(final String str) {

        assertThatThrownBy(() -> RacingCars.from(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해야 합니다.");
    }

    @DisplayName("참여한 자동차가 이동여부의 따라 이동 스코어를 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"true,1", "false,0"})
    void round_play(final boolean result, final int score) {

        final RacingCars racingCars = RacingCars.from("1");
        racingCars.roundPlay(() -> result);
        final List<RacingCar> racingCarList = racingCars.score();

        assertThat(racingCarList.get(0).getPosition()).isEqualTo(score);
    }

    @ParameterizedTest
    @DisplayName("입력한 자동차 대수의 자동차를 만든다")
    @CsvSource(value = {"1,1", "3,3", "5,5"})
    void cars_create(final String str, final int number) {

        final RacingCars racingCars = RacingCars.from(str);
        assertThat(racingCars.count()).isEqualTo(number);
    }

    @DisplayName("숫자 입력시 0인 경우 익셉션 처리한다.")
    @Test
    void input_zero() {

        assertThatThrownBy(() -> RacingCars.from("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 1 이상이어야 합니다.");
    }

    @DisplayName("숫자 입력시 문자가 포함된 경우 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"d1", "te"})
    void input_string(final String str) {

        assertThatThrownBy(() -> RacingCars.from(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해야 합니다.");
    }
}
