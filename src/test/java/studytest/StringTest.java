package studytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * Created by owen.ny on 2021/11/04.
 */
public class StringTest {

    @Test
    @DisplayName("String split 테스트")
    public void 요구사항1() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).contains("1");
    }

    @Test
    @DisplayName("String substring 테스트")
    public void 요구사항2() {
        assertThat("(1,2)".substring(1, 4).split(",")).contains("1", "2");
    }

    @Test
    @DisplayName("String charAt 테스트")
    public void 요구사항3() {
        assertThat("abc".charAt(1)).isEqualTo('b');

        assertThatThrownBy(() -> "abc".charAt(4)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
