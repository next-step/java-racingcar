package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2를 split")
    void step_1_splitTest1() {
        //given
        String numbers = "1,2";

        //when
        String[] arrayNumbers = numbers.split(",");

        //then
        assertThat(arrayNumbers).containsExactly("1", "2");
        /*
        containsExactily: 원소가 정확히 일치하는지 확인하는 테스트 메서드
         */
    }

    @Test
    @DisplayName("1을 split")
    void step_1_splitTest2() {
        //given
        String number = "1";

        //when
        String[] arrayNumber = number.split(",");

        //then
        assertThat(arrayNumber).contains("1");
        /*
        contains: 해당 원소 값이 들어가 있는지 확인하는 테스트메서드
         */
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져온다.")
    void specificLocationCharTest() {
        //given
        String message = "abc";

        //when
        char charAt = message.charAt(0);

        //then
        assertThat(charAt).isEqualTo('a');

    }

    @Test
    @DisplayName("위치 값을 벗어나면 예외가 발생한다")
    void indexOutOfBoundsExceptionTest() {
        //given
        String message = "abc";

        //then
        assertThatThrownBy(() -> message.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
