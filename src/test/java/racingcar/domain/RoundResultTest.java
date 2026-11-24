package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundResultTest {
    private static final CarName POBI = new CarName("pobi");
    private static final CarName CRONG = new CarName("crong");
    private static final CarName HONUX = new CarName("honux");

    @Test
    @DisplayName("가장 멀리 간 차가 우승한다")
    void singleWinner() {
        RoundResult result = new RoundResult(List.of(
                new CarResult(POBI, 3), new CarResult(CRONG, 1), new CarResult(HONUX, 2)));

        assertThat(result.getWinners()).containsExactly(POBI);
    }

    @Test
    @DisplayName("가장 멀리 간 차가 여럿이면 모두 우승한다")
    void multipleWinners() {
        RoundResult result = new RoundResult(List.of(
                new CarResult(POBI, 3), new CarResult(CRONG, 1), new CarResult(HONUX, 3)));

        assertThat(result.getWinners()).containsExactly(POBI, HONUX);
    }

    @Test
    @DisplayName("생성에 쓴 목록이 바뀌어도 결과는 바뀌지 않는다")
    void notAffectedBySourceList() {
        List<CarResult> source = new ArrayList<>(List.of(new CarResult(POBI, 1)));
        RoundResult result = new RoundResult(source);

        source.add(new CarResult(CRONG, 5));

        assertThat(result.carResults()).containsExactly(new CarResult(POBI, 1));
    }
}
