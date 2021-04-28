package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingcarTest {

    RacingCar racingCar = new RacingCar();

    @ParameterizedTest
    @ValueSource(strings = {"gyubin", "sangkoo", "kyeonghwan"})
    void nameCheckTest(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingCar.nameCheck(input);
        });
    }

    @Test
    void carNameSplit() {
        String[] split = "gyubin,sangkoo,kyeonghwan".split(",");
        assertThat(split[0]).isEqualTo("gyubin");
        assertThat(split[1]).isEqualTo("sangkoo");
        assertThat(split[2]).isEqualTo("kyeonghwan");
    }
}
