package racingcar.service;

import racingcar.comparator.PositionComparator;
import racingcar.dto.Board;
import racingcar.domain.Name;
import racingcar.domain.Cars;
import racingcar.dto.RacingInfo;
import racingcar.domain.Position;
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

    public List<Name> findWinners() {
        List<Position> lastRecords = cars.getCarsPositions();
        List<Name> lastGameNames = cars.getNames();

        Position winnersPosition = Collections.max(lastRecords, new PositionComparator());

        return IntStream.range(0, lastRecords.size())
                .filter(i -> lastRecords.get(i).compare(winnersPosition))
                .mapToObj(i -> lastGameNames.get(i))
                .collect(Collectors.toList());
    }

    public Board race(MovingStrategy movingStrategy) {
        cars.move(movingStrategy);
        board.record(cars);

        return board;
    }
}
