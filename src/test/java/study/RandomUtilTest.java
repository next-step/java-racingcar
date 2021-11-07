package study;

import static org.assertj.core.api.Assertions.*;

import com.step3.model.Car;
import com.step3.util.RandomUtil;
import org.junit.jupiter.api.Test;


public class RandomUtilTest {
    @Test
    void getRandomValue() {
        assertThat(RandomUtil.getRandomValue()).isGreaterThanOrEqualTo(0).isLessThan(9);
    }
}