package racingcar.domain;

import java.util.List;
import java.util.Map;

public interface RacingGameRepository {

    int save(Cars cars);

    Map<Integer, Cars> getGameResultSet();

    List<String> getWinners();
}
