package carracing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarRacingTest {

    private static final Integer PASS_NUMBER = 1;

    private static final Integer FALL_NUMBER = 0;

    private static final String TWO_DASH = "--";

    @Test
    @DisplayName("차의 대수가 0보다 작을 때 예외처리")
    void validCarsQuantity() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new CarRacing(FALL_NUMBER, PASS_NUMBER))
            .withMessage(RacingUtils.CARS_QUANTITY_EXCEPTION);
    }

    @Test
    @DisplayName("시도할 횟수가 0보다 작을 때 예외처리")
    void validMovementQuantity() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new CarRacing(PASS_NUMBER, FALL_NUMBER))
            .withMessage(RacingUtils.MOVEMENT_QUANTITY_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("입력 값인 차의 대수 만큼 Array 생성 됐는지 확인")
    @ValueSource(ints = {5, 6, 4})
    void carsArray(int carsQuantity) {
        CarRacing carRacing = new CarRacing(carsQuantity, PASS_NUMBER);
        assertThat(carRacing.getCarsSize()).isEqualTo(carsQuantity);
    }

    @ParameterizedTest
    @DisplayName("run 성공 확인")
    @CsvSource(value = {"5:4", "3:1"}, delimiter = ':')
    void runSuccess(Integer input, Integer idx) {
        // given
        CarRacing carRacing = new CarRacing(input, PASS_NUMBER);

        // when
        carRacing.run(idx);

        // then
        assertThat(carRacing.getCars().get(idx)).isEqualTo(TWO_DASH);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:5", "3:4"}, delimiter = ':')
    void runException(Integer input, Integer idx) {
        CarRacing carRacing = new CarRacing(input, PASS_NUMBER);

        assertThatExceptionOfType(NullPointerException.class)
            .isThrownBy(() -> carRacing.run(idx))
            .withMessage(RacingUtils.CARS_NON_KEY);
    }

}
