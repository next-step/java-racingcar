package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("String.split 문자열 분리 기본 테스트")
    public void splitTest() {
        assertThat("1,2".split(","))
                .containsExactly("1", "2");
    }

    @Test
    @DisplayName("String.split에서 분리할 패턴이 없을 때의 테스트")
    public void splitTestOnNoMatchString() {
        assertThat("1".split(","))
                .as("split 패턴이 문자열에 없을 때는 주어진 문자열을 원소로만 하는 배열을 반환해야 함")
                .containsExactly("1");
    }

    @Test
    @DisplayName("String.substring 기본 테스트")
    public void substringTest() {
        assertThat("(1,2)".substring(1,4))
                .isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource({"0,a", "1,b", "2,c"})
    @DisplayName("String.charAt 기본 테스트")
    public void charAtTest(int index, char expected) {
        assertThat("abc".charAt(index))
                .as("abc에서 인덱스 %d 글자 조회", index)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("String.charAt 범위 벗어난 참조 테스트")
    public void charAtOutOfRangeTest(int outOfIndexIndex) {
        assertThatThrownBy(() -> {
            "abc".charAt(outOfIndexIndex);
        })
        .as("{} index를 이용한 charAt 호출 시도")
        .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("개행 문자가 문자열 길이에 포함되는지 테스트")
    public void checkNewLineCharacterLength() {
        assertThat("12\n34".length())
                .isEqualTo(5);
    }
}
