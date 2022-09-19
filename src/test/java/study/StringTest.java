package study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class StringTest {
    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현.")
    void step1(){
        String test = "1,2";

        String[] result = test.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현.")
    void step2(){
        String test = "(1,2)";

        String result = test.substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현.")
    void step3(){
        String test = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    test.charAt(test.length()+1);
                }).withMessageContaining("String index out of range:");
    }
}
