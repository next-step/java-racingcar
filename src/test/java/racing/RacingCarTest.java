package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings={"pobi", "crong", "honux", "nextstep"})
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    public void nameTest(String carName) {
        RacingCar racingCar = RacingCar.init(carName);
        assertThat(racingCar.getName()).hasSizeLessThan(RacingCar.MAX_NAME_SIZE);
    }
}
