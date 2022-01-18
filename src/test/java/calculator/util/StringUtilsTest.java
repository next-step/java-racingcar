package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void 문자열_분리_테스트() {
        String[] splitExpression = StringUtils.splitExpression("1 2");
        assertThat(splitExpression).isEqualTo(new String[]{"1", "2"});
        assertThat(splitExpression.length).isEqualTo(2);
    }

    @Test
    void 문자열_분리_예외_테스트() {
        String[] splitExpression = StringUtils.splitExpression("1\2");
        assertThat(splitExpression.length).isEqualTo(1);
    }
}