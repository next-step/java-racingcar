import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    static String[] splitedStrings;

    @BeforeEach
    public void setSplitStrings() {
        splitedStrings = "1,2".split(",");
    }

    // contains는 배열시 순서상관 없음
    @Test
    public void 요구사항1_contains1to2() {
        assertThat(splitedStrings).contains("1", "2");
    }

    @Test
    public void 요구사항1_contains2to1() {
        assertThat(splitedStrings).contains("2", "1");
    }

    //containsExactly의 경우 순서 상관 있음
    @Test
    public void 요구사항1_containsExactly1to2() {
        assertThat(splitedStrings).containsExactly("1", "2");
    }

//    @Test
//    public void 요구사항1_containsExactly2to1() {
//        assertThat(splitedStrings).containsExactly("2", "1");
//    }

    @Test
    public void 요구사항1_containsOnly1() {
        splitedStrings = "1".split(",");
        assertThat(splitedStrings).containsExactly("1");
    }

    @Test
    public void 요구사항2() {
        String subString = "(1,2)".substring(1, 4);
        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt을 이용한 특정위치 문자 가져오기")
    public void 요구사항3_0번째() {
        String input = "abc";
        char getByInput = input.charAt(0);
        assertThat(getByInput).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt이 위치범위를 벗어날 경우")
    public void 요구사항3_위치값벗어날경우() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");

//        assertThrows(StringIndexOutOfBoundsException.class, () -> input.charAt(-1));
    }
}
