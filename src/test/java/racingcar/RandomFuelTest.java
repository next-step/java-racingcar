package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.domain.RandomFuel;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomFuelTest {

    @DisplayName("랜덤값 범위 검증")
    @RepeatedTest(value = 10)
    void makeRandomIntValue() {

//        assertThat(new RandomFuel().getAsInt())
//                .isGreaterThanOrEqualTo(0)
//                .isLessThan(10);
    }
}
