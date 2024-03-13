package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.RacingCars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {
    @Test
    void 자동차리스트_생성() {
        RacingCars racingCars = new RacingCars("audi,bmw,benz");
        assertThat(racingCars.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "audi,ferrari", "audi,,bmw"})
    void 잘못된_자동차리스트_생성(String names) {
        assertThatThrownBy(() -> new RacingCars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
