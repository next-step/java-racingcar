package com.next.step.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringClassTest {

    @Test
    @DisplayName("String \"1,2\" 입력이 주어지고 split을 이용할 때 1과 2가 배열에 반환되는지 확인하는 테스트")
    void testSplitBySemicolonNumbers() {
        String delimiter = ",";
        String inputString = "1,2";

        String[] dividedInput = inputString.split(delimiter);

        assertThat(dividedInput).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String \"1\" 입력이 주어지고 split을 이용할 때 1만 포함하는 배열이 반환되는지 확인하는 테스트")
    void testSplitBySemicolonNumber() {
        String delimiter = ",";
        String inputString = "1";

        String[] dividedInput = inputString.split(delimiter);

        assertThat(dividedInput).containsExactly("1");
    }

    @Test
    @DisplayName("String \"(1,2)\" 입력이 주어지고 substring을 이용할 때 소괄호가 제거되는지 확인하는 테스트")
    void testRemoveBracketBySubstring() {
        String inputString = "(1,2)";

        String unbracketedInput = inputString.substring(1, 4);

        assertThat(unbracketedInput).contains("1,2");
        assertThat(unbracketedInput).doesNotContain("(");
        assertThat(unbracketedInput).doesNotContain(")");
    }

    @Test
    @DisplayName("String \"abc\" 입력이 주어지고 charAt를 이용할 때 특정 위치 문자를 가져오는지 확인하는 테스트")
    void testGetCharacterUsingCharAt() {
        String inputString = "abc";

        char firstCharacter = inputString.charAt(0);
        char secondCharacter = inputString.charAt(1);
        char thirdCharacter = inputString.charAt(2);

        assertThat(firstCharacter).isEqualTo('a');
        assertThat(secondCharacter).isEqualTo('b');
        assertThat(thirdCharacter).isEqualTo('c');
    }

    @Test
    @DisplayName("String \"abc\" 입력이 주어지고 charAt를 이용해 범위를 벗어나는 인덱스 접근 시 예외가 발생하는지 확인하는 테스트")
    void testStringIndexOutOfBoundsExceptionUsingCharAt() {
        String inputString = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> inputString.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }
}
