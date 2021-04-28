package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingcarTest {

    RacingCar racingCar = new RacingCar();

    @ParameterizedTest
    @ValueSource(strings = {"gyubin", "sangkoo", "kyeonghwan"})
    void nameCheckTest(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingCar.nameCheck(input);
        });
    }
}
