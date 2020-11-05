package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceReadyValueTest {

    @DisplayName("RaceReadyValue() 테스트 : carCount, tryCount 생성자 테스트")
    @Test
    void raceReadyValue() {
        int carCount = 3;
        int tryCount = 5;

        RaceReadyValue raceReadyValue = new RaceReadyValue(carCount, tryCount);

        assertThat(raceReadyValue.carCount).isEqualTo(carCount);
        assertThat(raceReadyValue.tryCount).isEqualTo(tryCount);
    }

}
