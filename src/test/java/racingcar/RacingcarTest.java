package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {

    RacingCar racingCar = new RacingCar();
    NonTestRacingCar nonTestRacingCar = new NonTestRacingCar();

    @ParameterizedTest
    @ValueSource(strings = {"gyubin", "sangkoo", "kyeonghwan"})
    void nameCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingCar.nameCheck(input);
        });
    }

}
