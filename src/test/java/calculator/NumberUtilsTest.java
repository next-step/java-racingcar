package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilsTest {

    @Test
    void isInteger(){
        assertThat(NumberUtils.isInteger("123")).isTrue();
        assertThat(NumberUtils.isInteger("")).isFalse();
        assertThat(NumberUtils.isInteger("djfldskj")).isFalse();
    }
}
