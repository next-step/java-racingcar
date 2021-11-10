package racingcar.step5.domain;

import java.util.List;

import static racingcar.step5.message.ErrorMessage.*;

public class RacingGame {

    private static final int COUNT_OF_TRY_MIN_NUM = 1;
    private int countOfTry;
    private Cars cars;

    public RacingGame(String carName, int countOfTry) {
        checkCountOfTry(countOfTry);
        this.countOfTry = countOfTry;
        this.cars = new Cars(carName);
    }

    //테스트 코드를 위한 메서드
    public RacingGame(Cars cars, int countOfTry) {
        checkCountOfTry(countOfTry);
        this.countOfTry = countOfTry;
        this.cars = cars;
    }

    public boolean isEndGame() {
        return countOfTry == 0;
    }

    public void race(MovingStrategy movingStrategy) {
        cars.moveCars(movingStrategy);
        countOfTry--;
    }

    public int getCountOfTry() {
        return countOfTry;
    }

    public Cars getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }

    private static void checkCountOfTry(int countOfTry) {
        if (countOfTry < COUNT_OF_TRY_MIN_NUM) {
            throw new IllegalArgumentException(NO_ZERO_LESS_MESSAGE);
        }
    }

}
