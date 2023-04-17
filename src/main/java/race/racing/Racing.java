package race.racing;

import race.car.RacingCars;
import race.car.Car;
import race.car.Name;
import race.car.dto.CarInfoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private final RacingCars racingCars;
    private final int matchCount;
    private static final Random random = new Random();

    public Racing(int matchCount, List<String> carNames) {
        this.racingCars = this.racingCarRegistration(carNames);
        this.matchCount = matchCount;
    }

    private RacingCars racingCarRegistration(List<String> carNames) {
        final List<Car> racingCars = new ArrayList<>();

        for (String carName : carNames) {
            racingCars.add(new Car(new Name(carName)));
        }

        return new RacingCars(racingCars);
    }

    /**
     * 스코어보드라는 상태를 가지지않고 바로 반환하게 구현했습니다.
     */
    public List<List<CarInfoDto>> race() {
        final List<List<CarInfoDto>> scoreBoard = new ArrayList<>();

        for (int i = 0; i < this.matchCount; i++) {
            this.carMove();
            scoreBoard.add(this.racingCars.carScore());
        }

        return scoreBoard;
    }

    private void carMove() {
        this.racingCars.carMove(random);
    }
}