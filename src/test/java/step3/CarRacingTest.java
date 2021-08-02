package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarRacingTest {

    @Test
    @DisplayName("입력한 자동차 수만큼 객체가 생성됐는지 확인한다.")
    void input_car_count() {
        //given
        int carCount = 3;

        //when
        CarRacing carRacing = new CarRacing(carCount);

        //then
        assertThat(carRacing.racing().size()).isEqualTo(carCount);
    }

    @ParameterizedTest
    @CsvSource({"3", "5"})
    @DisplayName("racing()을 테스트한다.")
    void doRacingStart(int carCount) {
        assertThatCode(() -> {
            CarRacing carRacing = new CarRacing(carCount);
            carRacing.racing();
        }).doesNotThrowAnyException();
    }
}