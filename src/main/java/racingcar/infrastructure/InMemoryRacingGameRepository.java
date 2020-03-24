package racingcar.infrastructure;

import racingcar.domain.Cars;
import racingcar.domain.RacingGameConstant;
import racingcar.domain.RacingGameRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racingcar.domain.RacingGameConstant.NUMBER_ONE;

public class InMemoryRacingGameRepository implements RacingGameRepository {
    private static final Map<Integer, Cars> racingGameResults = new HashMap<>();

    private int index = RacingGameConstant.NUMBER_ZERO;

    @Override
    public int save(Cars cars) {
        racingGameResults.putIfAbsent(index++, cars);
        return index;
    }

    @Override
    public Map<Integer, Cars> getGameResultSet() {
        return racingGameResults;
    }

    @Override
    public List<String> getWinners() {
        int lastGameRound = Math.subtractExact(racingGameResults.size(), NUMBER_ONE);
        return racingGameResults.get(lastGameRound)
                .getWinners();
    }
}
