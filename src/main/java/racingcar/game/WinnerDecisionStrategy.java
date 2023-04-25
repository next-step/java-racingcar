package racingcar.game;

import racingcar.car.Car;
import racingcar.car.Winners;

import java.util.List;

public interface WinnerDecisionStrategy {
    Winners decideWinners(List<Car> allParticipants);
}
