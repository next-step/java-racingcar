package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RacingCarTests {

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("랜덤으로 뽑혔던 숫자가 4보다 작을 경우 false를 반환한다.")
    void canRaceStart(int times) {
        assertThat(Cars.isMovable(times)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {5})
    @DisplayName("입력한 자동차 대수 크기에 맞게 레이스 보드 배열이 생성된다.")
    void generateBoard(int cars) {
        assertThat(new RaceBoard(cars).generate().length).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("입력한 자동차 대수가 3대라면 초기 레이스 보드는 [-, -, -] 형태이다.")
    void generateBoardArrays(int cars) {
        assertThat(Arrays.toString(new RaceBoard(cars).generate())).isEqualTo("[-, -, -]");
    }

    @Test
    @DisplayName("랜덤으로 생성하는 전진 횟수는 0에서 9 사이의 숫자이다.")
    void generateRandomValue() {
        assertThat(Race.getRandomValue())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:5"}, delimiter = ':')
    @DisplayName("4 이상의 랜덤숫자가 나왔다면 자동차를 1칸 전진시킨다.")
    void carMoves(int cars, int randomValue) {
        String[] board = new RaceBoard(cars).generate();
        assertThat(Cars.isMovable(randomValue)).isTrue();

        String carMoved = new Cars(board[cars- 1]).go();
        assertThat(carMoved).isEqualTo("--");
    }

    @ParameterizedTest
    @CsvSource(value = {"2:3"}, delimiter = ':')
    @DisplayName("4보다 작은 랜덤숫자가 나왔다면 자동차를 전진시키지 않는다.")
    void carDoNotMove(int cars, int randomValue) {
        String[] board = new RaceBoard(cars).generate();
        assertThat(Cars.isMovable(randomValue)).isFalse();

        assertThat(Arrays.toString(board)).isEqualTo("[-, -]");
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("결과를 담은 배열 값이 출력되는지 검증한다.")
    void showResult(int cars) {
        String[] board = new RaceBoard(cars).generate();

        RaceResult raceResult = mock(RaceResult.class);
        raceResult.show();
        verify(raceResult, times(1));
    }
}
