package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    private static final String SPLITTER = ",";

    @Test
    @DisplayName("[요구사항 1-1] '1,2'를 ,로 split했을 때 1과 2로 잘 분리되는지 확인하는 테스트 메서드")
    void 요구사항_1_1() {
        // given
        String givenString = "1,2";
        String[] expectedResult = {"1", "2"};

        // when
        String[] result = givenString.split(SPLITTER);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("[요구사항 1-2] '1'을 ,로 split했을 때 1만을 포함하는 배열이 반환되는지 확인하는 테스트 메서드")
    void 요구사항_1_2() {
        // given
        String givenString = "1";
        String[] expectedResult = {"1"};

        // when
        String[] result = givenString.split(SPLITTER);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("[요구사항 2] '(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()를 제거하고 '1,2'를 반환하도록 구현")
    void 요구사항_2() {
        // given
        String givenString = "(1,2)";
        String expectedResult = "1,2";

        // when
        String result = givenString.substring(1,4);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("[요구사항 3-1] 'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트 구현")
    void 요구사항_3_1() {
        // given
        String givenString = "abc";
        char expectedResult = 'b';

        // when
        char result = givenString.charAt(1);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("[요구사항 3-2] 위치 값을 벗어날 경우 StringIndexOutOfBoundsException이 발생하는지 테스트")
    void 요구사항_3_2() {
        // given
        String givenString = "abc";
        int givenNumber = 10;

        // when, then
        Assertions.assertThatThrownBy(() -> {
                    givenString.charAt(givenNumber);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining(String.format("String index out of range: %d", givenNumber));
    }
}
