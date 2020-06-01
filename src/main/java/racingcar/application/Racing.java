package racingcar.application;

import racingcar.domain.RacingCar;
import racingcar.utils.Const;
import racingcar.utils.RandomUtils;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {
    private final int tryTime;
    private List<RacingCar> racingCars;

    public Racing(int carNum, int tryTime) {
        racingCars = createRacingCar(carNum);
        this.tryTime = tryTime;
    }

    private List<RacingCar> createRacingCar(int carNum) {
        return IntStream.range(Const.INITIAL_NUM, carNum)
                .mapToObj(car -> new RacingCar())
                .collect(Collectors.toList());
    }

    public List<RacingCarPositions> startRace() {
        List<RacingCarPositions> racingCarPositions = new ArrayList<>();
        IntStream.range(Const.INITIAL_NUM, tryTime)
                .forEach(tryNum -> racingCarPositions.add(moveCars()));
        return racingCarPositions;
    }

    private RacingCarPositions moveCars() {
        List<RacingCarPosition> racingCarPositions = new ArrayList<>();
        racingCars.forEach(car -> {
            moveCar(car);
            racingCarPositions.add(new RacingCarPosition(car.getPosition()));
        });
        return new RacingCarPositions(racingCarPositions);
    }

    private void moveCar(RacingCar car) {
        int randomNumber = RandomUtils.generateRandomNum();
        car.move(() -> car.isMove(randomNumber));
    }
}
