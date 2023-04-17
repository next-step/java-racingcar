package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;


class StringTest {

    @Test
    void splitContainTest() {
        assertThat("1,2".split(",")).contains("1","2");
    }
    @Test
    void splitContainExactlyTest() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void substringTest() {
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기 성공")
    void charAtTest_성공() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기 실패: IndexOutOfBoundsException 발생 확인")
    void charAtTest_실패() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    @Test
    void stringToChar_and_정수여부판단() {
        assertThat("1".chars().allMatch(Character::isDigit)).isTrue();
        assertThat("1.1".chars().allMatch(Character::isDigit)).isFalse();
        assertThat("-1".chars().allMatch(Character::isDigit)).isFalse();
        assertThat("가".chars().allMatch(Character::isDigit)).isFalse();
        assertThat("-".chars().allMatch(Character::isDigit)).isFalse();
    }

    @Test
    void stringJoinTest() {
        assertThat(IntStream.range(0, 3).mapToObj(i -> "-")
                .collect(Collectors.joining())).isEqualTo("---");
    }
}