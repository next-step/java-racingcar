package Study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    /**
     * 요구사항1
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     */
    @Test
    void stringSplit() {
        String[] words = "1,2".split(",");
        assertThat(words).contains("1", "2");
        assertThat(words).containsExactly("1", "2");
    }

    /**
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    void returnOnlyOne() {
        String[] words = "1,".split(",");
        assertThat(words).contains("1");
        assertThat(words).containsExactly("1");
    }

    /**
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    void substringTest() {
        String strs = "(1,2)";
        int length = strs.length();

        String substring = strs.substring(1, length - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 성공 테스트 index : 0")
    void stringCharAtTest1() {
        char c = "abc".charAt(0);
        assertThat(c).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt() 성공 테스트 index : 1")
    void stringCharAtTest2() {
        char c = "abc".charAt(1);
        assertThat(c).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 성공 테스트 index : 2")
    void stringCharAtTest3() {
        char c = "abc".charAt(2);
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() IndexOutOfBounds 실패 테스트 with assertThatThrownBy")
    void stringCharAtIndexOutOfBoundsTest1() {
        assertThatThrownBy(() -> {
            "abc".charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    @DisplayName("charAt() IndexOutOfBounds 실패 테스트 with assertThatExceptionOfType")
    void stringCharAtIndexOutOfBoundsTest2() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            "abc".charAt(7);
        }).withMessageMatching("String index out of range: \\d+");
    }
}
