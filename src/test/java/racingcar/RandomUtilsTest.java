package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.action.RandomMovable;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilsTest {

    @Test
    @DisplayName("0~9 사이의 숫자를 랜덤함수로 생성하는지 확인")
    public void isCorrectRandomValue() {
        RandomMovable randomMovable = new RandomMovable();
        assertThat(randomMovable.makeRandomValue()).isBetween(0,9);
    }
}
