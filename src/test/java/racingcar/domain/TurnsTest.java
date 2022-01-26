package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnsTest {
    final String TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";
    final String TURN_NOT_NUMBER_ERROR_MESSAGE = "입력한 값은 숫자가 아닙니다.";
    final String TURN_NOT_NATURAL_NUMBER_ERROR_MESSAGE = "시도할 횟수는 1 이상이어야 합니다.";

    @Test
    public void 입력_횟수가_정상적인_숫자라면_Exception발생안한다() {
        //given
        String turn = "10";

        //when

        //then
        assertThatCode(() -> Turn.createTurn(turn)).doesNotThrowAnyException();
    }

    @Test
    public void 입력_횟수는_널이면안된다() {
        //given
        String turn = "  ";

        //when

        //then
        assertThatCode(() -> Turn.createTurn(turn)).hasMessageContaining(TURN_MESSAGE);
    }

    @Test
    public void 입력_횟수는_자연수여야한다() {
        //given
        String turn = "0";

        //when

        //then
        assertThatCode(() -> Turn.createTurn(turn)).hasMessageContaining(TURN_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
    }

    @Test
    public void 입력_횟수는_오직_숫자여야한다() {
        //given
        String turn1 = "string";
        String turn2 = "+*#@$(";

        //when

        //then
        assertThatCode(() -> Turn.createTurn(turn1)).hasMessageContaining(TURN_NOT_NUMBER_ERROR_MESSAGE);
        assertThatCode(() -> Turn.createTurn(turn2)).hasMessageContaining(TURN_NOT_NUMBER_ERROR_MESSAGE);
    }
}