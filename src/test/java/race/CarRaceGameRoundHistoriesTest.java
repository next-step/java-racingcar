package race;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CarRaceGameRoundHistoriesTest {
    @Test
    void record_게임_라운드_진행상황을_기록한다() {
        int roundCount = 5;
        Map<Integer, List<CarRaceGameHistory>> historyMap = createHistoryMap(roundCount);

        CarRaceGameRoundHistories result = CarRaceGameRoundHistories.create(historyMap);
        assertThat(result).isEqualTo(CarRaceGameRoundHistories.create(historyMap));
    }

    @Test
    void get_게임_라운드_진행기록_조회시_새로_생성하여_반환한다() {
        int roundCount = 5;
        CarRaceGameRoundHistories roundHistories = CarRaceGameRoundHistories.create(createHistoryMap(roundCount));

        assertThat(roundHistories.get() == roundHistories.get()).isFalse();
    }


    @Test
    void selectWinners_게임_라운드_진행기록으로_우승자를_선정한다() {
        int roundCount = 5;
        List<String> winnerNames = Arrays.asList("kim", "lee");
        CarRaceGameRoundHistories roundHistories = CarRaceGameRoundHistories.create(
                createHistoryMap(roundCount, winnerNames));

        assertThat(roundHistories.selectWinners()).isEqualTo(winnerNames);
    }

    private static Map<Integer, List<CarRaceGameHistory>> createHistoryMap(int roundCount) {
        Map<Integer, List<CarRaceGameHistory>> carRaceGameRoundHistoryMap = new HashMap<>();

        IntStream.rangeClosed(1, roundCount)
                .forEach(round -> carRaceGameRoundHistoryMap.put(round, createHistories(round)));

        return carRaceGameRoundHistoryMap;
    }

    private static Map<Integer, List<CarRaceGameHistory>> createHistoryMap(int roundCount, List<String> winnerNames) {
        Map<Integer, List<CarRaceGameHistory>> carRaceGameRoundHistoryMap = new HashMap<>();

        IntStream.rangeClosed(1, roundCount - 1)
                .forEach(round -> carRaceGameRoundHistoryMap.put(round, createHistories(round)));

        carRaceGameRoundHistoryMap.put(roundCount, createWinningHistories(roundCount, winnerNames));

        return carRaceGameRoundHistoryMap;
    }

    private static List<CarRaceGameHistory> createHistories(int round) {
        return Arrays.asList(
                CarRaceGameHistory.record(round, (int) (Math.random() * 10 - 1) + 1, "hani"),
                CarRaceGameHistory.record(round, (int) (Math.random() * 10 - 1) + 1, "minji"),
                CarRaceGameHistory.record(round, (int) (Math.random() * 10 - 1) + 1, "dani")
        );
    }


    private static List<CarRaceGameHistory> createWinningHistories(int finalRound, List<String> winnerNames) {
        return winnerNames.stream()
                .map(winnerName -> CarRaceGameHistory.record(finalRound, Integer.MAX_VALUE, winnerName))
                .collect(Collectors.toList());

    }
}
