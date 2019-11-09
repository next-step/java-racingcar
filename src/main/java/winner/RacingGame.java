package winner;

import winner.domain.Car;
import winner.domain.RacingCars;
import winner.domain.TryNo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 01:39
 */
public class RacingGame {

    private RacingCars racingCars;
    private TryNo tryNo;

    public RacingGame(String[] careNames, int inputTryNo) {
        this.racingCars = new RacingCars(createCars(careNames));
        this.tryNo = new TryNo(inputTryNo);
    }

    private List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    public void start() {
        this.racingCars.move();
        this.tryNo.decrease();
    }

    public boolean isNotEnd() {
        return this.tryNo.isNotEnd();
    }

    public List<Car> getRacingCars() {
        return racingCars.getCars();
    }

    public String getWinners() {
        return racingCars.findWinners();
    }
}
