package camp.nextstep.edu.rebellion.racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {
    @DisplayName("null 케이스일 경우 empty 확인")
    @Test
    public void nullTest() {
        // given
        String str = null;

        // when
        boolean expected = StringUtil.isEmpty(str);

        // then
        assertThat(expected).isTrue();
    }

    @DisplayName("공백 케이스일 경우 empty 확인")
    @Test
    public void emptySpaceTest() {
        // given
        String str = "";

        // when
        boolean expected = StringUtil.isEmpty(str);

        // then
        assertThat(expected).isTrue();
    }

    @DisplayName("문자열을 리스트로 잘 변환하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "A,B,C:A:3",
            "AA,  BB,CC:CC:3"},
            delimiter = ':')
    public void convertListTest(String str, String containValue, int expected) {
        // when
        List<String> result = StringUtil.convertList(str, ",");

        // then
        assertAll(
                () -> assertThat(result).hasSize(expected),
                () -> assertThat(result).contains(containValue)
        );

    }
}
