package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ResultCarPositionsTest {

    private ResultCarPositions resultCarPositions;

    public ResultCarPositionsTest() {
        List<int[]> carPositions = Arrays.asList(
                new int[] { 1, 0, 0, 1 },
                new int[] { 1, 0, 1, 2 },
                new int[] { 2, 1, 1, 2 },
                new int[] { 3, 2, 1, 2 },
                new int[] { 3, 2, 2, 3 }
        );
        resultCarPositions = ResultCarPositions.newInstance(carPositions);
    }

    @DisplayName("자동차 결과가 없을 경우 만들 수 없다.")
    @Test
    void canNotCreateResultCarPositionsIfCarPositionsIsNull() {
        assertThatThrownBy(() -> ResultCarPositions.newInstance(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 결과 리스트 크기가 0 일 경우 생성할 수 없다.")
    @Test
    void canNotCreateResultCarPositionsIfSizeOfCarPositionsIsZero() {
        assertThatThrownBy(() -> ResultCarPositions.newInstance(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 결과 리스트 크기가 각각 다를 경우 생성할 수 없다.")
    @Test
    void canNotCreateResultCarPositionsIfCarPositionsOfDifferentSize() {
        assertThatThrownBy(() -> ResultCarPositions.newInstance(Arrays.asList(new int[4], new int[5], null)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 결과 리스트가 정상일 경우 생성할 수 있다.")
    @Test
    void canCreateResultCarPositions() {
        assertThat(resultCarPositions).isNotNull();
    }

    @DisplayName("자동차 대수를 얻을 수 있다.")
    @Test
    void canGetCarCountForResultCarPositions() {
        assertThat(resultCarPositions.getCarCount()).isEqualTo(4);
    }

    @DisplayName("자동차 경주 총 회수를 얻을 수 있다.")
    @Test
    void canGetTotalRoundForRacingGame() {
        assertThat(resultCarPositions.getTotalRound()).isEqualTo(5);
    }

    @DisplayName("특정 시점에 대한 자동차 위치를 얻을 수 있다.")
    @Test
    void canGetPositionsForResultCarPositions() {
        List<int[]> result = Arrays.asList(
                new int[] { 1, 0, 0, 1 },
                new int[] { 1, 0, 1, 2 },
                new int[] { 2, 1, 1, 2 },
                new int[] { 3, 2, 1, 2 },
                new int[] { 3, 2, 2, 3 }
        );

        IntStream.range(0, resultCarPositions.getTotalRound())
                .forEach(round -> assertArrayEquals(resultCarPositions.getPositions(round), result.get(round)));
    }
}
