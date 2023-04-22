package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @DisplayName("raceCount가 음수인 경우 RuntimeException")
    @Test
    void test1(){
        int raceCount = -1;
        int carCount = 1;

        Assertions.assertThatThrownBy(() -> Race.from(raceCount, carCount, () -> carCount))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("carCount가 음수인 경우 RuntimeException")
    @Test
    void test2(){
        int raceCount = 1;
        int carCount = -1;

        Assertions.assertThatThrownBy(() -> Race.from(raceCount, carCount, () -> carCount))
                .isInstanceOf(RuntimeException.class);
    }
}