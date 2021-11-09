package racingcar.step5.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int COUNT_OF_TRY_MIN_NUM = 1;
    private static final String NAME_DELIMITER = ",";
    private int countOfTry;
    private Cars cars;

    public RacingGame(String carName, int countOfTry) {
        checkCountOfTry(countOfTry);
        this.countOfTry = countOfTry;
        this.cars = new Cars(carName.split(NAME_DELIMITER));
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
        return cars.getCars().stream()
                .filter(this::isMaxPosition)
                .collect(Collectors.toList());
    }

    private static void checkCountOfTry(int countOfTry) {
        if (countOfTry < COUNT_OF_TRY_MIN_NUM) {
            throw new IllegalArgumentException("0 이하 값은 불가능 합니다.");
        }
    }

    private boolean isMaxPosition(Car car) {
        return car.getPosition() == cars.getMaxPosition();
    }

}
