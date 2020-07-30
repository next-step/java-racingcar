package camp.nextstep.edu.rebellion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {
    @DisplayName("1,2 문자열을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    public void splitTest() {
        // given
        String str = "1,2";

        // when
        String[] result = str.split(",");

        // then
        assertAll(
                () -> assertThat(result.length).isEqualTo(2),
                () -> assertThat(result).contains("1"),
                () -> assertThat(result).contains("2")
        );
    }

    @DisplayName("1, 문자열을 ,로 split 했을 때 1만 포함하는 배열이 반환되는지 확인")
    @Test
    public void splitSingleArrayTest() {
        // given
        String str = "1,";

        // when
        String[] result = str.split(",");

        // then
        assertAll(
                () -> assertThat(result.length).isEqualTo(1),
                () -> assertThat(result).containsExactly("1")
        );
    }

    @DisplayName("(1,2) 문자열이 주어졌을 때 substring 메소드를 활용하여 () 제거")
    @Test
    public void substringTest() {
        // given
        String str = "(1,2)";

        // when
        String deletedPrefix = str.substring(str.indexOf("(") + 1);
        String deletedSuffix = deletedPrefix.substring(0, deletedPrefix.indexOf(")"));

        // then
        assertAll(
                () -> assertThat(deletedPrefix).isEqualTo("1,2)"),
                () -> assertThat(deletedSuffix).isEqualTo("1,2")
        );
    }

    @DisplayName("abc 문자열이 주어졌을 때 chartAt()을 활용하여 특정 위치의 문자를 가져오는지 확인")
    @Test
    public void charAtTest() {
        // given
        String str = "abc";

        // when
        char result  = str.charAt(0);

        // then
        assertThat(result).isEqualTo('a');
    }

    @DisplayName("chartAt()을 활용하여 특정 위치의 문자를 가져올 때 위치 값 벗어나면 Exception 발생")
    @Test
    public void charAtThrownExceptionTest() {
        // given
        String str = "abc";

        // when
        assertThatThrownBy(() -> str.charAt(10))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 10");
    }
}
