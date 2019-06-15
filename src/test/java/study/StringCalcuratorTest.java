package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-15
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class StringCalcuratorTest {

    private StringCalculator calcurator;

    @BeforeEach
    void setUp() {
        calcurator = new StringCalculator();
    }

    @Test
    void 계산() {
        assertThat(calcurator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @AfterEach
    void tearDown() {

    }
}
