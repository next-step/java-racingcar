package racingGame.participant;

import racingGame.car.Car;
import racingGame.game.RacingGameRule;

import java.util.List;

public interface Participants {

    void gameStart(RacingGameRule carForwardRule);

    RoundScore getRoundScore();

    List<Car> getWinners();
}
