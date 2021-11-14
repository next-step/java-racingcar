package racingcar.domain.gameround;

import racingcar.domain.model.Cars;

import java.util.*;

public interface GameRound {
    List<String> getResult(Cars cars);
}