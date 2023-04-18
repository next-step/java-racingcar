package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {
    @DisplayName("4단계 - 자동차 경주(우승자) - 입력된 이름 문자열을 쉼표(',')를 기준으로 나누어 반환되는지 확인")
    @Test
    void split_by_comma() {
        String testData = "name1,name2";
        assertThat(StringUtil.split(testData)).containsExactly("name1", "name2");
    }
}
