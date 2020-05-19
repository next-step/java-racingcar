package racingCar.application;

import racingCar.domain.MoveBehavior;
import racingCar.domain.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private final String[] carNames;
    private final int carCount;
    private final int time;
    private final List<RacingCar> racingCarList = new ArrayList<>();

    public RacingGame(String[] carNames, int time) {
        validateRange(carNames.length, time);
        this.carNames = carNames;
        this.carCount = carNames.length;
        this.time = time;
        initRacingCars();
    }

    private void validateRange(int carCount, int time) {
        if (carCount <= 0 || time <= 0) {
            throw new IllegalArgumentException("0이하는 경기를 진행할 수가 없습니다.");
        }
    }

    private void initRacingCars() {
        Arrays.stream(carNames).forEach(name -> racingCarList.add(new RacingCar(name)));
    }

    // TODO 구현
    public void move(MoveBehavior moveBehavior) {
        racingCarList.forEach(racingCar -> racingCar.move(moveBehavior.isMove()));
    }

    public List<RacingCar> winners() {
        racingCarListSort();
        List<RacingCar> winnerList = new ArrayList<>();
        //List<RacingCar> winnerList = racingCarList.stream().filter().collect(Collectors.toList());
        return winnerList;
    }
    private void racingCarListSort() {
        racingCarList.sort((first, second) -> {
            if (first.getPosition() == second.getPosition()) {
                return 0;
            }
            return (first.getPosition() < second.getPosition()) ? -1 : 1;
        });
    }

    public int getTime() {
        return time;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
