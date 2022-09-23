package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("랜덤 숫자가 4이상인 경우(true) 전진하며, 4미만인 경우(false) 정지한다.")
    @ParameterizedTest
    @CsvSource(value = {"false,0", "true,1"})
    void car_move(final boolean movable, final int position) {

        final RacingCar racingCar = RacingCar.init();
        racingCar.move(() -> movable);

        assertThat(racingCar.distance()).isEqualTo(position);
    }
}
