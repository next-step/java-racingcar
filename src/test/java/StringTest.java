import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void splitMultipleTest() {
        String testString = "1,3";

        String[] split = testString.split(",");

        assertThat(split)
                .contains("1","3")
                .hasSize(2);
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void splitSingleTest() {
        String testString = "1,";

        String[] split = testString.split(",");

        assertThat(split)
                .containsExactly("1")
                .hasSize(1);
    }

    @Test
    @DisplayName("substring() 메소드를 활용해 () 제거 확인")
    void subStringTest() {
        String testString = "(1,2)";

        String substring = testString.substring(testString.indexOf("("), testString.indexOf(")"));

        assertThat(substring)
                .contains("1","2")
                .endsWith("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생 확인")
    void charAtTest() {
        String testString = "abc";

        assertThatThrownBy(()->{
            testString.charAt(testString.length());
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining(String.valueOf(testString.length()));

    }
}