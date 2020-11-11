package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    private final String[] nameOfCars = {"car1", "car2", "car3", "car4"};
    private RacingCars racingCars;
    private static final int FINAL_ROUND = 6;

    @DisplayName("다음 라운드 정상 진행 여부")
    @Test
    void nextRoundTest() {
        Round round = new Round(FINAL_ROUND);
        racingCars = RacingCars.of(nameOfCars, () -> true, round);
        racingCars.run();
        assertThat(round.nextRound()).isEqualTo(2);
    }

    @DisplayName("마지막 라운드 시 true 반환 여부")
    @Test
    void finalRoundTest() {
        Round round = new Round(5);
        racingCars = RacingCars.of(nameOfCars, () -> true, round);
        for (int i = 0; i < 5; i++) {
            racingCars.run();
        }
        assertThat(round.isLastRound()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("게임 라운드 정상 진행 여부")
    @ValueSource(ints = {10, 25, 30})
    void gameRoundTest(int roundCount) {
        Round round = new Round(roundCount);
        racingCars = RacingCars.of(nameOfCars, () -> true, round);
        round.progressRound(racingCars);
        assertThat(round.getRound()).isEqualTo(roundCount);
    }
}
