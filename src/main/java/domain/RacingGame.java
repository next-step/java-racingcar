package domain;

import java.util.List;
import java.util.Map;

/**
 * 자동차 경주
 */
public class RacingGame {
    private static final int DEFAULT_MIN_BOUND = 4;
    private static final int DEFAULT_MAX_BOUND = 10;
    private final Cars cars;
    private final Option option;

    /**
     * 생성자 - 다양한 옵션 설정
     */
    public RacingGame(Cars cars) {
        this(cars, 0);
    }

    public RacingGame(String names, int round) {
        this(new Cars(names), round);
    }

    public RacingGame(Cars cars, int round) {
        this(cars, round, DEFAULT_MIN_BOUND, DEFAULT_MAX_BOUND);
    }

    public RacingGame(Cars cars, Option option) {
        this.cars = cars;
        this.option = option;
    }

    public RacingGame(Cars cars, int round, int minBound, int maxBound) {
        this.cars = cars;
        this.option = new Option(round, minBound, maxBound);
    }

    /**
     * 전체 라운드 기준 랜덤 이동 메서드
     */
    public void moveByRoundRandomly() {
        int round = option.getRound();
        for (int i = 0; i < round; i++) {
            moveByRandomly();
        }
    }

    /**
     * 라운드별 전체 랜덤 이동 메서드
     */
    public void moveByRandomly() {
        cars.moveAllWithRandom(option);
    }

    public int size() {
        return cars.size();
    }

    public int getRound() {
        return option.getRound();
    }

    public List<Car> findWinners() {
        return cars.getCarsWithSamePosition(cars.getMaxPosition());
    }

    public Map<String, Integer> getGameStats() {
        return cars.getCarInformation();
    }

}
