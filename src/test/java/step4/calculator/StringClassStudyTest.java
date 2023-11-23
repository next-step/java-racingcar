package step4.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringClassStudyTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    public void 요구사항1() throws Exception {
        // given
        String test = "1,2";
        // when
        String[] split = test.split(",");

        // then
        assertThat(split).containsExactly("1","2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void 요구사항1_2() throws Exception {
        // given
        String test = "1";

        // when
        String[] split = test.split(",");

        // then
        assertAll(
                () -> assertNotNull(split)
                , () -> assertEquals(split.length,1)
        );
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    public void 요구사항2() throws Exception {
        // given
        String test = "(1,2)";
        // when
        String s = test.replaceAll("[()]", "");
        // then
        assertThat(s).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    public void 요구사항3() throws Exception {
        // given
        String test = "abc";
        // when
        char second = test.charAt(1);
        // then
        assertThat(second).isEqualTo('b');
    }
    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습")
    public void 요구사항3_1() throws Exception {
        // given
        String test = "abc";
        // when then
        Assertions.assertThrows(
                StringIndexOutOfBoundsException.class, () -> test.charAt(4)
        );
    }
}
