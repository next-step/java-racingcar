package step3;

import CarRacing.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilsTest {
    static final int FIRST_NUMBER = 0;
    static final int LAST_NUMBER = 9;

    @DisplayName("0에서 9까지 임의의 숫자를 생성")
    @Test
    void generateRandomNumberTest() {
        assertThat(RandomUtils.generateRandom()).isBetween(FIRST_NUMBER, LAST_NUMBER);
    }

}
