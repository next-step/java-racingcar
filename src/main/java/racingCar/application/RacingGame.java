package racingCar.application;

import racingCar.domain.MoveBehavior;
import racingCar.domain.RacingCar;
import racingCar.domain.RandomMove;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private final int carCount;
    private final int time;
    private List<RacingCar> racingCarList;

    public RacingGame(int carCount, int time) {
        validateRange(carCount, time);
        this.carCount = carCount;
        this.time = time;
        initRacingCars();
    }

    private void validateRange(int carCount, int time) {
        if (carCount <= 0 || time <= 0) {
            throw new IllegalArgumentException("0이하는 경기를 진행할 수가 없습니다.");
        }
    }

    private void initRacingCars() {
        racingCarList = Stream.generate(RacingCar::new)
                            .limit(carCount)
                            .collect(Collectors.toList());
    }

    // TODO 구현
    public void move(MoveBehavior moveBehavior) {
        racingCarList.forEach(racingCar -> racingCar.move(moveBehavior.isMove()));
    }

    public int getTime() {
        return time;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
