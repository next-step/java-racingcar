package com.rick.racing;

import static org.assertj.core.api.Assertions.assertThat;

import com.rick.racing.core.CarRacingCore;
import com.rick.racing.model.CarRecordHistory;
import com.rick.racing.model.RacingPlayData;
import com.rick.racing.model.RacingResult;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

    private final CarRacingCore carRacing = new CarRacingCore();

    private List<Boolean> goOrStopList;
    private int goOrStopIndex;

    @Test
    @DisplayName("코어 로직이 의도핸 대로 동작하는지 확인")
    void testDoGame() {
        final int carCount = 3;
        final int tryCount = 5;
        goOrStopList = Lists.list(true, false, true, true, false,
            true, false, true, true, true,
            true, false, true, false, true);
        goOrStopIndex = 0;

        final List<List<Integer>> expected = Lists.list(
            Lists.list(1, 1, 2, 3, 3),
            Lists.list(1, 1, 2, 3, 4),
            Lists.list(1, 1, 2, 2, 3)
        );

        RacingPlayData racingPlayData = new RacingPlayData(carCount, tryCount);
        RacingResult racingResult = carRacing.doGame(racingPlayData, this::isGo);

        for (int carIndex = 0; carIndex < carCount; carIndex++) {
            final CarRecordHistory carRecordHistory = racingResult.getRecord(carIndex);
            for (int tryIndex = 0; tryIndex < tryCount; tryIndex++) {
                assertThat(carRecordHistory.getPosition(tryIndex)).isEqualTo(
                    expected.get(carIndex).get(tryIndex));
            }
        }
    }

    private boolean isGo() {
        return goOrStopList.get(goOrStopIndex++);
    }
}
