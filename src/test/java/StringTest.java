import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void 요구사항1(){
        assertThat("1,2".split(",")).containsExactly("1","2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void 요구사항2(){
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    void 요구사항3(){
        assertThatThrownBy(() -> {
            assertThat("abc".charAt(0)).isEqualTo('a');
            assertThat("abc".charAt(3)).isEqualTo('a');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
