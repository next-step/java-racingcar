package step3.racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import step3.racingCar.util.NumberRandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

class NumberRandomUtilTest {
    @RepeatedTest(100)
    @DisplayName("범위 안에 랜덤값")
    void generate_randomNumber_range() {
        int randomNum = NumberRandomUtil.generate();
        assertThat(randomNum).isBetween(0, 9);
    }

    @RepeatedTest(100)
    @DisplayName("음수 랜덤값")
    void generate_randomNumber_negative() {
        int randomNum = NumberRandomUtil.generate();
        assertThat(randomNum).isGreaterThanOrEqualTo(0);
    }

    @RepeatedTest(100)
    @DisplayName("10이상 랜덤값")
    void generate_randomNumber_up10() {
        int randomNum = NumberRandomUtil.generate();
        assertThat(randomNum).isLessThanOrEqualTo(9);
    }

}
