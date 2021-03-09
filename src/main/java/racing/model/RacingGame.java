package racing.model;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private final RacingCars cars;

    public RacingGame(String[] racingCarNames) {
        this.cars = new RacingCars(racingCarNames);
    }

    /**
     * 자동차가 이동할 랜덤값 생성 메서드
     */
    public List<Integer> createRandomValue() {
        return new Random()
                .ints(0, 10)
                .limit(cars.carCount())
                .boxed()
                .collect(toList());
    }

    /**
     * 조건에 따라 자동차를 이동시켜주는 메서드
     */
    public void moveAndStop(List<Integer> randomValue) {
        cars.move(randomValue);
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

    public List<RacingCarDto> createDtoList() {
        return cars.createDtoList();
    }
}
