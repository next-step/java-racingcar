package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {
    @DisplayName("4단계 - 자동차 경주(우승자) - 입력된 문자열을 쉼표(',')를 기준으로 나누어 반환되는지 확인")
    @Test
    void split_by_comma() {
        String testData = "name1,name2";
        assertThat(StringUtil.split(testData)).containsExactly("name1", "name2");
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 입력된 문자열에 쉼표(',') 구분자가 없는경우 문자열 그대로 반환되는지 확인")
    @Test
    void split_single_value_by_comma() {
        String testData = "name1";
        assertThat(StringUtil.split(testData)).containsExactly("name1");
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 리스트 형태의 문자열들을 쉼표(',') 를 기준으로 합쳐 하나의 문자열로 반환하는지 확인")
    @Test
    void join_by_comma() {
        String[] testData = {"name1", "name2"};
        assertThat(StringUtil.join(testData)).isEqualTo("name1, name2");
    }
}
