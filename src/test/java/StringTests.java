import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTests {
    @DisplayName("String '1,2'를 ','로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void stringSplitWithTwoNumbers() {
        assertThat("1,2".split(",")).contains("1");
        assertThat("1,2".split(",")).contains("2");
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @DisplayName("String '1'을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @Test
    void stringSplitWithOneNumber() {
        assertThat("1".split(",")).contains("1");
        assertThat("1".split(",")).containsExactly("1");
    }

    @DisplayName("String '(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환하는지 확인")
    @Test
    void stringSubstring() {
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @DisplayName("String 'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAtTestWithinValidIndexNumber(int indexNumber, char targetValue) {
        assertThat("abc".charAt(indexNumber)).isEqualTo(targetValue);
    }

    @DisplayName(
            "String의 charAt()를 사용해서 특정 위치의 문자를 가져올 때" +
            "위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인"
    )
    @ParameterizedTest
    @ValueSource(ints = {3, 300, 3000})
    public void charAtTestWithInvalidIndexNumber(int invalidIndexNumber) {
        assertThatThrownBy(() -> "abc".charAt(invalidIndexNumber)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
