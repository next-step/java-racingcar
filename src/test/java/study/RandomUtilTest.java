package study;

import static org.assertj.core.api.Assertions.*;

import com.step3.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RandomUtilTest {
    @Test
    @DisplayName("0~9 사이의 숫자 추출 test")
    void getRandomValue() {
        assertThat(RandomUtil.getRandomValue()).isGreaterThanOrEqualTo(0).isLessThan(10);
    }
}