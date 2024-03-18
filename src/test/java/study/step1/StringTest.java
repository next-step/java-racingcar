package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    /**
     * 요구사항 1
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    /**
     * 요구사항 2
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    void substring() {
        String given = "(1,2)";
        String result = given.substring(1, given.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    /**
     * 요구사항 3
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    @DisplayName("문자열 인덱스 범위를 벗어나면, StringIndexOutOfBoundsException")
    void charAt() {
        String given = "abc";

//        assertThatThrownBy(() -> given.charAt(-1))
//                .isInstanceOf(IndexOutOfBoundsException.class)
//                .hasMessageContaining("String index out of range");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> given.charAt(-1))
                .withMessageContaining("String index out of range");
    }
}
