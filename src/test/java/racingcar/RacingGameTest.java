package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @DisplayName("차 수, 시도 횟수 만큼 결과 리턴")
    @ParameterizedTest
    @CsvSource({"5,5", "4,3"})
    void run(int expectedNumberOfCars, int expectedTryCount) {
        RacingGame racingGame = new RacingGame(new RacingCarMovableStrategy(), expectedNumberOfCars, expectedTryCount);
        List<List<Integer>> carPositions = racingGame.run();
        int tryCount = carPositions.size();
        assertThat(tryCount).isEqualTo(expectedTryCount);

        int numberOfCars = carPositions.get(0).size();
        assertThat(numberOfCars).isEqualTo(expectedNumberOfCars);
    }
}