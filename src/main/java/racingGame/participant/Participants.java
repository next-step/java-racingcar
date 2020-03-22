package racingGame.participant;

import racingGame.car.Car;
import racingGame.game.RacingGameRule;

import java.util.List;

public interface Participants {

    RoundScore startRound(RacingGameRule carForwardRule);

    List<Car> getWinners();
}
