package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.assertj.core.api.Assertions.*;

class NumberRandomizerTest {
    @RepeatedTest(100)
    @DisplayName("범위 안에 랜덤값")
    void generate_randomNumber_range() {
        int randomNum = NumberRandomizer.generate();
        assertThat(randomNum).isBetween(0, 9);
    }

    @RepeatedTest(100)
    @DisplayName("음수 랜덤값")
    void generate_randomNumber_negative() {
        int randomNum = NumberRandomizer.generate();
        assertThat(randomNum).isGreaterThanOrEqualTo(0);
    }

    @RepeatedTest(100)
    @DisplayName("10이상 랜덤값")
    void generate_randomNumber_up10() {
        int randomNum = NumberRandomizer.generate();
        assertThat(randomNum).isLessThanOrEqualTo(9);
    }

}
