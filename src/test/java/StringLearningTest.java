import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringLearningTest {

    String abc;

    @BeforeEach
    void setUp(){
        abc = "abc";
    }

    @Test
    void 요구사항1(){
        String test1 = "1,2";
        String[] result1Arr = test1.split(",");
        assertThat(result1Arr).containsExactly("1", "2");

        String test2 = "1,";
        String[] result2Arr = test2.split(",");
        assertThat(result2Arr).containsExactly("1");
    }

    @Test
    void 요구사항2(){
        String test1 = "(1,2)";
        String result = test1.substring(1, test1.length() - 1);
        assertThat(result).contains("1,2");
    }
    @Test
    @DisplayName("charAt()의 Learning Test - 범위 내의 a, b, c가져오기")
    void 요구사항3_1(){
        char a = abc.charAt(0);
        char b = abc.charAt(1);
        char c = abc.charAt(2);
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt()의 Learning Test - 범위 밖의 값을 가져오기")
    void 요구사항3_2(){
        assertThatThrownBy(() -> {
            abc.charAt(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: -1");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
            abc.charAt(3);
        }).withMessageMatching("String index out of range: \\d+");
    }


}
