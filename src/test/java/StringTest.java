import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:38 오후
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringTest {

    @Order(1)
    @Test
    @DisplayName("요구사항 1.")
    public void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1");
        assertThat(values).contains("2");

        assertThat(values).containsExactly("1", "2");
    }

    @Order(2)
    @Test
    @DisplayName("요구사항 2.")
    public void substring() {
        String values = "(1,2)";
        String substring = values.substring(1, 4);

        assertThat(substring).contains("1,2");
    }

    @Order(3)
    @Test
    @DisplayName("요구사항 3. 특정 값의 index를 가져올때 예외를 발생하는 테스트")
    public void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }


}
