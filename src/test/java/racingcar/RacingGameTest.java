package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @ParameterizedTest
    @DisplayName("모든차가 움직임에 성공했을 때 테스트")
    @CsvSource(value = {"5:1", "6:2", "7:3", "8:4", "9:4"}, delimiter = ':')
    void moveCarAllSuccessTest(int randomValue, int runCount) {
        RacingGame racingGame = new RacingGame(3, () -> randomValue);
        ArrayList<Integer> carPositionsAtInit = racingGame.getCurrentCarPositions();

        racingGame.startRacing(runCount);
        ArrayList<Integer> carPositionsAtEnd = racingGame.getCurrentCarPositions();

        for (int i = 0; i < carPositionsAtEnd.size(); i++) {
            assertThat(carPositionsAtEnd.get(i)).isEqualTo(carPositionsAtInit.get(i) + runCount);
        }
    }

    @ParameterizedTest
    @DisplayName("모든차가 움직임에 실패했을 때 테스트")
    @CsvSource(value = {"0:1", "1:2", "2:3", "3:4", "4:4"}, delimiter = ':')
    void moveCarAllFailTest(int randomValue, int runCount) {
        RacingGame racingGame = new RacingGame(3, () -> randomValue);
        ArrayList<Integer> carPositionsAtInit = racingGame.getCurrentCarPositions();
        racingGame.startRacing(runCount);
        ArrayList<Integer> carPositionsAtEnd = racingGame.getCurrentCarPositions();

        for (int i = 0; i < carPositionsAtEnd.size(); i++) {
            assertThat(carPositionsAtEnd.get(i)).isEqualTo(carPositionsAtInit.get(i));
        }
    }

    @ParameterizedTest
    @DisplayName("실행수 입력 값이 1이상이 아니면 IllegalArgumentException 테스트")
    @ValueSource(ints = {0, -1, -99})
    void validateRunCountTest(int runCount) {
        assertThatThrownBy(() -> {
                    RacingGame racingGame = new RacingGame(3);
                    racingGame.startRacing(runCount);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("Car 총 갯수 입력 값이 1이상이 아니면 IllegalArgumentException 테스트")
    @ValueSource(ints = {0, -1, -99})
    void validateCarTotalCountTest(int carTotalCount) {
        assertThatThrownBy(() -> {
                    RacingGame racingGame = new RacingGame(carTotalCount);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
