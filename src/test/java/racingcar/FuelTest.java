package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class FuelTest {

    @DisplayName("랜덤값 범위 검증")
    @RepeatedTest(value = 10)
    void makeRandomIntValue() {

        assertThat(Fuel.inject()).isGreaterThanOrEqualTo(0)
                .isLessThan(10);
    }
}
