package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import step5.util.NumberRandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

class NumberRandomUtilTest {
    @RepeatedTest(100)
    @DisplayName("범위 안에 랜덤값")
    void generate_randomNumber_range() {
        int randomNum = NumberRandomUtil.generate();
        assertThat(randomNum).isBetween(0, 9);
    }

    @DisplayName("랜덤값 여러개")
    @Test
    void generateRandomNums() {
        assertThat(NumberRandomUtil.generateList(3)).hasSize(3);
    }
}
