package me.namuhuchutong.step4;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarServiceTest {

    @DisplayName("경주 결과의 총 횟수와 주어진 경주 횟수가 동일해야 한다.")
    @Test
    void test() {
        CarNames names = CarNames.from(List.of("a", "b"));
        UserInputInformation inputInformation = new UserInputInformation(names, 3);
        RacingResult racingResult = new RacingCarService().runRacing(inputInformation);

        assertThat(racingResult.getTotalRaceCount()).isEqualTo(inputInformation.getTimes());
    }
}
