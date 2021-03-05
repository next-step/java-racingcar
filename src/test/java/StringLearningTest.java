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
    @DisplayName("요구사항 1) String의 split을 테스트")
    void splitTest(){
        String test1 = "1,2";
        String[] result1Arr = test1.split(",");
        assertThat(result1Arr).containsExactly("1", "2");

        String test2 = "1,";
        String[] result2Arr = test2.split(",");
        assertThat(result2Arr).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2) subString을 테스트")
    void subStringTest(){
        String test1 = "(1,2)";
        String result = test1.substring(1, test1.length() - 1);
        assertThat(result).contains("1,2");
    }
    @Test
    @DisplayName("요구사항 3) charAt()의 Learning Test - 범위 내의 a, b, c가져오기")
    void validateCharAtIndexIn(){
        char a = abc.charAt(0);
        char b = abc.charAt(1);
        char c = abc.charAt(2);
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항 3-1) charAt()의 Learning Test - 범위 밖의 값을 가져오기")
    void validateCharAtIndexOut(){
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
