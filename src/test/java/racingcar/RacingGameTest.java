package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {

    @DisplayName("차량 수, 라운드 수 만큼 결과 리턴")
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

    @DisplayName("0 이하로 차량 수 또는 라운드 수 입력시 오류")
    @ParameterizedTest
    @CsvSource({"0,0", "1,0", "1,-1", "0,1", "-1,1"})
    void constructorException(int numberOfCars, int tryCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame(new RacingCarMovableStrategy(), numberOfCars, tryCount));
    }
}