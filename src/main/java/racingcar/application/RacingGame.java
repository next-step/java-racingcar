package racingcar.application;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarPositions;
import racingcar.domain.RacingCars;
import racingcar.utils.Const;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final int tryTime;
    private RacingCars racingCars;


    public RacingGame(String inputCarNames, int tryTime) {
        existCarNames(inputCarNames);
        String[] splitCarNames = splitComma(inputCarNames);
        racingCars = createRacingCar(splitCarNames);
        this.tryTime = tryTime;
    }

    public List<RacingCarPositions> startRace() {
        List<RacingCarPositions> racingCarPositionHistories = new ArrayList<>();
        IntStream.range(Const.INITIAL_NUM, tryTime)
                .forEach(it -> racingCarPositionHistories.add(racingCars.moveCars()));
        return racingCarPositionHistories;
    }

    private void existCarNames(String inputCarNames) {
        if (inputCarNames == null || inputCarNames.isEmpty())
            throw new IllegalArgumentException("이름을 입력해주세요.");
    }

    private String[] splitComma(String inputCarNames) {
        return inputCarNames.split(Const.SYMBOL_COMMA);
    }

    private RacingCars createRacingCar(String[] carNames) {
        return new RacingCars(IntStream.range(Const.INITIAL_NUM, carNames.length)
                .mapToObj(index -> new RacingCar(carNames[index]))
                .collect(Collectors.toList()));
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
