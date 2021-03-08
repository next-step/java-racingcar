package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.action.RandomMovable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomUtilsTest {

    @Test
    @DisplayName("0~9 사이의 숫자를 랜덤함수로 생성하는지 확인")
    public void isCorrectRandomValue() {
        RandomMovable randomMovable = new RandomMovable();
        assertThat(randomMovable.makeRandomValue()).isBetween(0,9);
    }

    @Test
    @DisplayName("랜덤 숫자가 4이상이면 전진이 가능한지 확인")
    public void isMoveOrNot() {
        RandomMovable randomMovable = new RandomMovable();
        assertEquals(true,randomMovable.moveOrNot(4));
    }

    @Test
    @DisplayName("랜덤 숫자가 4미만이면 전진이 가능한지 확인")
    public void isNotMoveOrNot() {
        RandomMovable randomMovable = new RandomMovable();
        assertEquals(false,randomMovable.moveOrNot(2));
    }
}
