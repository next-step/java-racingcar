package racingGame.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameDtoTest {

    @Test
    public void 공백으로_구분된_문자열을_comma_구분으로_정상_변환한다() {
        GameDto dto = new GameDto("aaa bbb ccc", "5");

        assertThat(dto.getCarNames()).isEqualTo("aaa,bbb,ccc");
    }

    @Test
    public void String_타입의_turn을_int_타입으로_정상_변환한다() {
        GameDto dto = new GameDto("aaa bbb ccc", "5");

        assertThat(dto.getTurn()).isInstanceOf(Integer.class).isEqualTo(5);
    }
}