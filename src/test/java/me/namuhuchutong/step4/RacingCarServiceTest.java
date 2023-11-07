package me.namuhuchutong.step4;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import me.namuhuchutong.step4.domain.CarNames;
import me.namuhuchutong.step4.domain.RacingCarService;
import me.namuhuchutong.step4.domain.rule.RacingRule;
import me.namuhuchutong.step4.dto.RacingResult;
import me.namuhuchutong.step4.dto.UserInputInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarServiceTest {

    private RacingRule alwaysMoveRule;

    @BeforeEach
    void setUp() {
        alwaysMoveRule = () -> true;
    }

    @DisplayName("경주 결과의 총 횟수와 주어진 경주 횟수가 동일해야 한다.")
    @Test
    void test() {
        //given
        CarNames names = CarNames.from(List.of("a", "b"));
        UserInputInformation inputInformation = new UserInputInformation(names, 3);

        //when
        RacingResult racingResult = new RacingCarService(alwaysMoveRule).runRacing(inputInformation);

        //then
        assertThat(racingResult.getTotalRaceCount()).isEqualTo(inputInformation.getTimes());
    }
}
