package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    final int carCount = 5;
    final int matchCount = 4;
    Racing racing;

    @BeforeEach
    void setUp() {
        this.racing = new Racing(carCount, matchCount);
    }

    @Test
    @DisplayName("레이싱에 참여하는 자동차의 댓수 식별")
    void racingCarCount() {

        assertThat(racing)
                .extracting("racingCars")
                .asList()
                .hasSize(carCount);
    }

    @Test
    @DisplayName("레이스 정보의 매치 횟수와 자동차 갯수 확인")
    void race() {
        racing.raceStart();
        final List<List<Integer>> carLocations = racing.scoreBoard();

        assertThat(carLocations)
                .hasSize(matchCount)
                .map(List::size)
                .containsExactly(carCount, carCount, carCount, carCount);

    }
}
