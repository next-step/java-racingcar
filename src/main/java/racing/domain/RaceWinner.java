package racing.domain;

import racing.dto.RaceWinnerResult;

import java.util.List;

@FunctionalInterface
public interface RaceWinner {

    RaceWinnerResult calculateWinners(List<Car> cars);
}
