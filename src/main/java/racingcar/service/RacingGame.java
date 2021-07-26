package racingcar.service;

import racingcar.dto.Board;
import racingcar.model.Cars;
import racingcar.dto.RacingInfo;
import racingcar.strategy.MovingStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final RacingInfo racingInfo;
    private final Cars cars;
    private Board board;

    public RacingGame(RacingInfo racingInfo, Cars cars) {
        this.racingInfo = racingInfo;
        this.cars = cars;
        this.board = new Board();
    }

    private List<String> getWinners(Board board) {
        List<List<Integer>> allRecords = board.getAllRecords();

        int lastGameIndex = allRecords.size() - 1;

        List<Integer> lastGameRecord = allRecords.get(lastGameIndex);
        List<String> lastGameCarNames = cars.getNames();

        int winnersScore = Collections.max(lastGameRecord);

        return IntStream.range(0, lastGameRecord.size())
                .filter(i -> lastGameRecord.get(i) >= winnersScore)
                .mapToObj(i -> lastGameCarNames.get(i))
                .collect(Collectors.toList());

    }

    public Board gameStart(MovingStrategy movingStrategy) {
        for (int i = 0; i < racingInfo.raceTrialCount; i++) {
            cars.move(movingStrategy);
            board.record(cars.getNames(), cars.getCarsPositions());
        }

        board.recordWinner(getWinners(board));

        return board;
    }
}
