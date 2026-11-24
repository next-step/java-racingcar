package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.CarName;
import racingcar.domain.CarResult;

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

    @ParameterizedTest
    @CsvSource(value = {"0:'pobi : '", "1:'pobi : -'", "3:'pobi : ---'"}, delimiter = ':')
    @DisplayName("차의 진행상태를 이름과 위치만큼의 '-'로 표시한다")
    void formatProgressOfCar(int position, String expected) {
        RoundResult result = new RoundResult(List.of(new CarResult(POBI, position)));

        assertThat(result.formatProgress()).isEqualTo(expected);
    }

    @Test
    @DisplayName("한 회차의 진행상태를 차마다 한 줄씩 표시한다")
    void formatProgress() {
        RoundResult result = new RoundResult(List.of(
                new CarResult(POBI, 2), new CarResult(CRONG, 0), new CarResult(HONUX, 1)));

        assertThat(result.formatProgress())
                .isEqualTo("pobi : --" + System.lineSeparator()
                        + "crong : " + System.lineSeparator()
                        + "honux : -");
    }

    @Test
    @DisplayName("우승자가 한 명이면 이름만 표시한다")
    void formatSingleWinner() {
        RoundResult result = new RoundResult(List.of(new CarResult(POBI, 3), new CarResult(CRONG, 1)));

        assertThat(result.formatWinners()).isEqualTo("pobi가 최종 우승했습니다.");
    }

    @Test
    @DisplayName("우승자가 여럿이면 쉼표로 구분해 표시한다")
    void formatMultipleWinners() {
        RoundResult result = new RoundResult(List.of(
                new CarResult(POBI, 3), new CarResult(CRONG, 1), new CarResult(HONUX, 3)));

        assertThat(result.formatWinners()).isEqualTo("pobi, honux가 최종 우승했습니다.");
    }
}
