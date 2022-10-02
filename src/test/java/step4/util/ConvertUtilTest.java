package step4.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertUtilTest {

    @Test
    @DisplayName("입력된 자동차 전진 수만큼 -가 출력되어 성공")
    void convertNumToDashSuccess() {
        StringBuilder sb = new StringBuilder();
        sb.append("---");

        assertThat(
                ConvertUtil.convertNumToDash(3))
                .isEqualToIgnoringCase(sb);
    }

    @Test
    @DisplayName("문자열을 콤마와 띄어쓰기를 분리해 문자열 배열로 생성해 성공")
    void splitStringToArraySuccess() {
        String value = "one, two,three";
        String[] result = new String[3];
        result[0] = "one";
        result[1] = "two";
        result[2] = "three";

        assertThat(
                Arrays.equals(
                ConvertUtil.splitStringToArray(value), result))
                .isTrue();
    }

    @Test
    @DisplayName("여러 문자열을 콤마를 더해 하나의 문자열로 생성해 성공")
    void joinStringByCommaOneValueSuccess() {
        Set<String> values = new HashSet<>();
        values.add("winner1");

        String value = "winner1";

        assertThat(
                ConvertUtil.joinStringByComma(values))
                .isEqualToIgnoringCase(value);
    }

    @Test
    @DisplayName("여러 문자열을 콤마를 더해 하나의 문자열로 생성해 성공")
    void joinStringByCommaMultipleValuesSuccess() {
        Set<String> values = new HashSet<>();
        values.add("winner1");
        values.add("winner2");

        String value = "winner1,winner2";

        assertThat(
                ConvertUtil.joinStringByComma(values))
                .isEqualToIgnoringCase(value);
    }
}
