package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.action.RandomMovable;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomUtilsTest {

    private RandomMovable randomMovable;

    @BeforeEach
    void setUp() {
        randomMovable = new RandomMovable();
    }

    @Test
    @DisplayName("0~9 사이의 숫자를 랜덤함수로 생성하는지 확인")
    public void isCorrectRandomValue() {
        randomMovable.makeRandomValue();
        assertThat(randomMovable.getRandomValue()).isBetween(0, 9);
    }
}
