package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundsTest {

    @Test
    @DisplayName("경기 수에 0을 입력하면 어떻게 되는가")
    public void isZero(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Rounds(0);
        });
    }

    @Test
    @DisplayName("경기수에 음수를 입력하면 어떻게 되는가")
    public void isNegative(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Rounds(-1);
        });
    }


}

