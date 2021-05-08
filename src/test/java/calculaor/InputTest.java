package calculaor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
//    private String input;
    private String blankInput;

    @BeforeEach
    void setUP() {
//        input = "2 + 3 * 4 / 2";
        blankInput = " ";
    }

    // 빈값 (null 값 or " ") 판단하기
    // null 값은 통과 못 함
    @Test
    void checkBlank() {
        // Given
        Input input = new Input();

        // when
        Boolean actual = input.checkBlank(blankInput);

        //then
        assertThat(actual).isTrue();
    }
}

