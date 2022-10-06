package racingcar.listener;

import racingcar.domain.Car;

import java.util.List;

public interface GameEventListener {
    void onStart();
    void afterRound(List<Car> cars);
    void afterGame(List<Car> cars);
}
