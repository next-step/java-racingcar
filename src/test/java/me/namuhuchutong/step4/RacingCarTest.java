package me.namuhuchutong.step4;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @DisplayName("자동차 경주 수는 음수이거나 0일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void number_of_racing_should_not_be_negative_or_zero(int times) {
        //given
        CarNames carNames = CarNames.from(List.of("a", "b", "c"));

        //when, then
        assertThatThrownBy(() -> new UserInputInformation(carNames, times))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
