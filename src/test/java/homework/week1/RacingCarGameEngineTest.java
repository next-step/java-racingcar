package homework.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarGameEngineTest {
        private RacingCarGameEngine carGameEngine;

    @BeforeEach
    void setUp() {
        carGameEngine = new RacingCarGameEngine("pobi,crong,honux", 5);
    }

    @Test
    void checkEmptyString_입력값빈문자입력시에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carGameEngine.checkEmptyString("");
        });
    }

    @Test
    void splitInput_문자열쉼표로자르기() {
        String[] carNames = carGameEngine.splitInput("qwe,asd,zxc");
        assertThat(carNames).containsExactly("qwe", "asd", "zxc");
    }


    @Test
    void positiveNumber_경주회수0이하숫자입력시에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carGameEngine.checkInputPositiveNum(-1);
            carGameEngine.checkInputPositiveNum(0);
        });
    }
/*
    @Test
    void checkRunCondition() {
        assertThat(carGameEngine.checkRunCondition(3)).isFalse();
        assertThat(carGameEngine.checkRunCondition(4)).isTrue();

    }

    @Test
    void getRunCount() {
        assertThat(carGameEngine.getRunCount(true, 0)).isEqualTo(1);
        assertThat(carGameEngine.getRunCount(false, 0)).isEqualTo(0);
    }
*/
}
