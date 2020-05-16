package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {

    @Test
    @DisplayName("정상적인 영영 안에서 랜덤 값 생성")
    void createRandomNumber() {
        int ten = 10;
        int result = CommonUtil.randomNumber(ten);

        assertThat(result).isBetween(0, 10);
    }
}
