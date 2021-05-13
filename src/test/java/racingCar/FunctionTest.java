package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void moveAbleTest() {
        // given
        int number = 4;
        Function function = new Function();

        // when
        boolean actual = function.moveAble(number);

        // then
        assertTrue(actual);
    }

    @Test
    @DisplayName("자동차 전진 실패 테스트")
    void notMoveAbleTest() {
        // given
        int number = 2;
        Function function = new Function();

        // when
        boolean actual = function.moveAble(number);

        // then
        assertFalse(actual);
    }


}
