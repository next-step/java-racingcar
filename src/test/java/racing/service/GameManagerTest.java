package racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.RaceResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GameManagerTest {


    @ParameterizedTest
    @ValueSource(strings = {"next,step,yoon"})
    @DisplayName("자동차 경주 테스트")
    void 자동차경주_게임_테스트(String names) {
        // given
        int maxLaps = 3;
        int setRecord1 = 3;
        int setRecord2 = 6;
        int setRecord3 = 9;

        // when
        GameManagerStub carRacing = new GameManagerStub(names, maxLaps);
        carRacing.start();

        List<RaceResult> raceResults = carRacing.getRaceRound().getRaceResults();
        List<Integer> results = new ArrayList<>();

        for(int i=0; i<3; i++) {
            results.add(raceResults.get(i).getResultCars().stream()
                    .mapToInt(Car::getDistance)
                    .sum());
        }

        // then
        assertAll(
                () -> assertThat(results.get(0)).isEqualTo(setRecord1),
                () -> assertThat(results.get(1)).isEqualTo(setRecord2),
                () -> assertThat(results.get(2)).isEqualTo(setRecord3)
        );
    }

}
