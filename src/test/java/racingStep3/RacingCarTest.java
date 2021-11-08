package racingStep3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingStep3.domain.Position;
import racingStep3.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("값이 정상적인 경우")
    @ValueSource(ints = {3,5,7})
    void create(int location) {
        Position position = Position.create(location);
        assertThat(position).isEqualTo(Position.create(location));
    }

    @Test
    @DisplayName("Null check")
    void nullcheck() {
        assertThatNullPointerException().isThrownBy(() -> new RacingCar(null));
    }
}
