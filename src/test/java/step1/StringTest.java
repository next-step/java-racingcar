package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringTest {


    @Test
    @DisplayName("'1,2'을 ,로 split 했을 때 1과 2로 잘 분리")
    void stringSplitMulti() {
        String given = "1,2";
        String[] splitArray = given.split(",");
        assertThat(splitArray).contains("1");
        assertThat(splitArray).contains("2");
        assertThat(splitArray).containsExactly("1", "2");
    }

    @Test
    @DisplayName("'1'을 ,로 split 했을 때 1만을 포함하는 배열 반환")
    void stringSplitSingle() {
        String given = "1";
        String[] splitArray = given.split(",");
        assertThat(splitArray).contains("1");
        assertThat(splitArray).doesNotContain("2");
        assertThat(splitArray).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때 ()을 제거하고 '1,2'를 반환")
    void stringSplitwithSubstring() {
        String given = "(1,2)";
        String[] splitArray = given.substring(1, 4).split(",");
        assertThat(splitArray).contains("1");
        assertThat(splitArray).contains("2");
        assertThat(splitArray).containsExactly("1", "2");
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자 확인")
    void stringCharAt() {
        String given = "abc";
        List<Character> then = Arrays.asList('a', 'b', 'c');
        for (int i = 0; i < given.length(); i++) {
            assertThat(given.charAt(i)).isEqualTo(then.get(i));
        }
    }


    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생 확인")
    void stringIndexOutOfBounds() {
        String given = "abc";
        int index = 4;

        if (index >= given.length()) {
            assertThatThrownBy(() -> given.charAt(index))
                    .isInstanceOf(StringIndexOutOfBoundsException.class);
        } else {
            assertThatCode(() -> given.charAt(index))
                    .doesNotThrowAnyException();
        }
    }

}
