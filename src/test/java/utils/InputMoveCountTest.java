package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputMoveCountTest {

    @Test
    @DisplayName("자동차 이동 거리 5를 알맞게 값을 받는지?")
    void input_move_5count() {
        //given
        System.setIn(new ByteArrayInputStream("5".getBytes(StandardCharsets.UTF_8)));

        //when
        int moveCount = InputMoveCount.inMoveCount();

        //then
        assertEquals(moveCount, 5);
    }

    @Test
    @DisplayName("자동차 이동 거리 입력시 숫자가 아닌 것을 입력할 때 에러처리")
    void input_move_count_non_int() {
        //given
        System.setIn(new ByteArrayInputStream("5ㅁㅁ".getBytes(StandardCharsets.UTF_8)));

        //when
        //then
        assertThatThrownBy(InputMoveCount::inMoveCount)
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자만 입력해주세요.");
    }
}
