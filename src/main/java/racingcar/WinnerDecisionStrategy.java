package racingcar;

import racingcar.car.Car;

import java.util.List;

public interface WinnerDecisionStrategy {
    List<Car> decideWinners(List<Car> allParticipants);
}
