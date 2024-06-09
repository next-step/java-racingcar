package racingcar.service.race;

import racingcar.domain.Car;

import java.util.List;

public interface RaceService {
    public int getRaceTryCount();
    public void raceStart(List<Car> cars, int tryCount);
    public void determineWinner(List<Car> cars);
}
