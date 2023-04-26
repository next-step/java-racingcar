package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.input.request.CarRequest;

class RaceTest {

    @DisplayName("raceCount가 음수인 경우 RuntimeException")
    @Test
    void test1(){
        int raceCount = -1;
        CarRequest carRequest = new CarRequest("");

        Assertions.assertThatThrownBy(() -> Race.from(raceCount, carRequest.toResource(), () -> 1))
                .isInstanceOf(RuntimeException.class);
    }

}