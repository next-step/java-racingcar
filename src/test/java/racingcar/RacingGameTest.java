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
    void startRacingAllSuccessTest(int randomValue, int runCount) {
        RacingGame racingGame = new RacingGame("피카츄,라이츄,파이리", () -> randomValue);
        ArrayList<Car> carsAtInit = racingGame.getCurrentCars();

        racingGame.startRacing(runCount);
        ArrayList<Car> carsAtEnd = racingGame.getCurrentCars();

        for (int i = 0; i < carsAtEnd.size(); i++) {
            assertThat(carsAtEnd.get(i).getPosition()).isEqualTo(carsAtInit.get(i).getPosition() + runCount);
        }
    }

    @ParameterizedTest
    @DisplayName("모든차가 움직임에 실패했을 때 테스트")
    @CsvSource(value = {"0:1", "1:2", "2:3", "3:4", "4:4"}, delimiter = ':')
    void startRacingAllFailTest(int randomValue, int runCount) {
        RacingGame racingGame = new RacingGame("피카츄,라이츄,파이리", () -> randomValue);
        ArrayList<Car> carsAtInit = racingGame.getCurrentCars();
        racingGame.startRacing(runCount);
        ArrayList<Car> carsAtEnd = racingGame.getCurrentCars();

        for (int i = 0; i < carsAtEnd.size(); i++) {
            assertThat(carsAtEnd.get(i).getPosition()).isEqualTo(carsAtInit.get(i).getPosition());
        }
    }

    @ParameterizedTest
    @DisplayName("실행수 입력 값이 1이상이 아니면 IllegalArgumentException 테스트")
    @ValueSource(ints = {0, -1, -99})
    void validateRunCountTest(int runCount) {
        assertThatThrownBy(() -> {
                    RacingGame racingGame = new RacingGame("피카츄, 라이츄");
                    racingGame.startRacing(runCount);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력한 차의 대수가 2이상이 아니면 IllegalArgumentException 테스트")
    @ValueSource(strings = {"피카츄", "피카츄,", "파이리"})
    void validateCarNamesTest(String carNames) {
        assertThatThrownBy(() -> {
                    RacingGame racingGame = new RacingGame(carNames);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
