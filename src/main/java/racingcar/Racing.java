package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {
    private static final int INITIAL_NUM = 0;
    private final int tryTime;
    private List<RacingCar> racingCars;

    public Racing(int carNum, int tryTime) {
        racingCars = createRacingCar(carNum);
        this.tryTime = tryTime;
    }

    private List<RacingCar> createRacingCar(int carNum) {
        return IntStream.range(INITIAL_NUM, carNum)
                .mapToObj(car -> new RacingCar())
                .collect(Collectors.toList());
    }

    public void startRace() {
        IntStream.range(INITIAL_NUM, tryTime)
                .forEach(tryNum -> moveCars());
    }

    public ResultView startRace2() {
        List<RacingCarPositions> racingCarPositions = new ArrayList<>();
        IntStream.range(INITIAL_NUM, tryTime)
                .forEach(tryNum -> {
                    racingCarPositions.add(moveCars2());
                });
        return ResultView.from(racingCarPositions);
    }

    private void moveCars() {
        racingCars.forEach(car -> {
            int randomNumber = RandomUtils.generateRandomNum();
            car.move(() -> car.isMove(randomNumber));
        });
    }

    private RacingCarPositions moveCars2() {
        List<RacingCarPosition> racingCarPositions = new ArrayList<>();
        racingCars.forEach(car -> {
            int randomNumber = RandomUtils.generateRandomNum();
            car.move(() -> car.isMove(randomNumber));
            racingCarPositions.add(new RacingCarPosition(car.getPosition()));
        });
        return new RacingCarPositions(racingCarPositions);
    }

    public List<RacingCar> getRacingCar() {
        return Collections.unmodifiableList(racingCars);
    }
}
