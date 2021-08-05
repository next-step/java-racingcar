package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.exception.InvalidUserInputException;

import java.util.List;

public class Race {
    private Cars cars;
    private int racingTime;
    private static final String INVALID_RACING_TIME_MESSAGE = "1회 이상의 게임 횟수를 입력해야 시작 가능합니다.";

    public Race(Cars cars, int racingTime) {
        checkRacingTimeValidation(racingTime);
        this.cars = cars;
        this.racingTime = racingTime;
    }

    public void startRace() {
        cars.moveCars();
    }

    public Cars getCars() {
        return this.cars;
    }

    public int getRacingTime() {
        return this.racingTime;
    }

    public List<Car> getRaceWinners() {
        int maxPosition = cars.getCarsMaxPosition();
        return cars.getWinnerCars(maxPosition);
    }

    private void checkRacingTimeValidation(int racingTime) {
        if (racingTime < 1) {
            throw new InvalidUserInputException(INVALID_RACING_TIME_MESSAGE);
        }
    }
}
