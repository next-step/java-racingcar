package racingcar.domain;

import racingcar.utils.Const;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingViews {
    private List<RacingCarPositions> racingCarPositions = new ArrayList<>();
    private List<RacingCar> racingCars;

    public RacingViews(int tryTime, RacingCars racingCars) {
        this.racingCars = racingCars.get();
        IntStream.range(Const.INITIAL_NUM, tryTime)
                .forEach(it -> racingCarPositions.add(moveCars()));
    }

    public List<RacingCarPositions> get() {
        return racingCarPositions;
    }

    private RacingCarPositions moveCars() {
        List<RacingCarPosition> racingCarPositions = new ArrayList<>();
        IntStream.range(Const.INITIAL_NUM, racingCars.size())
                .forEach(i -> {
                    RacingCar racingCar = racingCars.get(i);
                    int random = RandomUtils.generateRandomNum();
                    racingCar.move(() -> racingCar.isMove(random));
                    racingCarPositions.add(new RacingCarPosition(racingCar.getPosition()));
                });
        return new RacingCarPositions(racingCarPositions);
    }

}
