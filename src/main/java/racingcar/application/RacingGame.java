package racingcar.application;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarPosition;
import racingcar.domain.RacingCarPositions;
import racingcar.domain.RacingViews;
import racingcar.utils.Const;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final int tryTime;
    private List<RacingCar> racingCars;

    public RacingGame(String inputCarNames, int tryTime) {
        existCarNames(inputCarNames);
        String[] splitCarNames = splitComma(inputCarNames);
        racingCars = createRacingCar(splitCarNames);
        this.tryTime = tryTime;
    }

    public List<RacingCarPositions> startRace() {
        List<RacingCarPositions> racingCarPositions = new ArrayList<>();
        IntStream.range(Const.INITIAL_NUM, tryTime)
                .forEach(tryNum -> racingCarPositions.add(moveCars()));
        return racingCarPositions;
    }

    public RacingViews startRace2() {
        List<RacingCarPositions> racingCarPositions = new ArrayList<>();
        IntStream.range(Const.INITIAL_NUM, tryTime)
                .forEach(tryNum -> racingCarPositions.add(moveCars()));
        return new RacingViews(racingCarPositions);
    }

    private void existCarNames(String inputCarNames) {
        if (inputCarNames == null || inputCarNames.isEmpty())
            throw new IllegalArgumentException("이름을 입력해주세요.");
    }

    private String[] splitComma(String inputCarNames) {
        return inputCarNames.split(Const.SYMBOL_COMMA);
    }

    private List<RacingCar> createRacingCar(String[] carNames) {
        return IntStream.range(Const.INITIAL_NUM, carNames.length)
                .mapToObj(index -> new RacingCar(carNames[index]))
                .collect(Collectors.toList());
    }

    private RacingCarPositions moveCars() {
        List<RacingCarPosition> racingCarPositions = new ArrayList<>();
        racingCars.forEach(car -> racingCarPositions.add(new RacingCarPosition(moveCar(car))));
        return new RacingCarPositions(racingCarPositions);
    }

    private int moveCar(RacingCar car) {
        int randomNumber = RandomUtils.generateRandomNum();
        return car.move(() -> car.isMove(randomNumber));
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
