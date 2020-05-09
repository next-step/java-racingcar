package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항 1 : ,를 기준으로 split할 경우 값이 정확한지")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
        
        result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2 : substring method를 이용한 () 제")
    void replaceBracketToEmptySpace() {
        String input = "(1,2)";

        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("요구사항 3 : abc란 값이 주어졌을 경우 charAt method를 이용한 특정 문자 위치를 찾기")
    void findStringIndex(int searchIndex) {
        String input = "abc";

        char index = input.charAt(searchIndex);
        assertThat(index > -1 && index < input.length());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    @DisplayName("요구사항 3 : 문자열의 길이를 넘어간 index를 찾을 시 StringIndexOutOfBoundsException이 발생하는지 테스트")
    void notfoundStringIndex(int searchIndex) {
        assertThatThrownBy(() -> {
            "abc".charAt(searchIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
