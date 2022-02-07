package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnTest {

    @Test
    public void 입력_횟수가_정상적인_숫자라면_Exception발생안한다() {
        //given
        String turn = "10";

        //when

        //then
        assertThatCode(() -> Turn.validateTurn(turn)).doesNotThrowAnyException();
    }

    @Test
    public void 입력_횟수는_널이면안된다() {
        //given
        String turn = "  ";

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Turn.validateTurn(turn);
        });
    }

    @Test
    public void 입력_횟수는_자연수여야한다() {
        //given
        String turn = "0";

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Turn.validateTurn(turn);
        });
    }

    @Test
    public void 입력_횟수는_오직_숫자여야한다() {
        //given
        String turn1 = "string";
        String turn2 = "+*#@$(";

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Turn.validateTurn(turn1);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Turn.validateTurn(turn2);
        });
    }
}