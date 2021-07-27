package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumUtilTest {

    @DisplayName("랜덤 넘버 테스트")
    @Test
    public void randomNumTest() {
        int randomNum = RandomNumUtil.makeRandomNumber();
        assertThat(randomNum).isBetween(0,10);
    }

}