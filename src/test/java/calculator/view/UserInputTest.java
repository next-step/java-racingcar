package calculator.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserInputTest {

    String INPUT_ERROR_MESSAGE = "잘못된 입력입니다.";

    @Test
    public void 입력으로_널이_들어올수없다() {
        //given
        String input = "  ";

        //when


        //then
        assertThatCode(() -> new UserInput(input)).hasMessageContaining(INPUT_ERROR_MESSAGE);
    }
}