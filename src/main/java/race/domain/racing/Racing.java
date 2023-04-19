package race.domain.racing;

import race.domain.car.Car;
import race.domain.car.MovingStrategy;
import race.domain.car.Name;
import race.domain.car.RacingCars;
import race.domain.car.dto.CarInfoDto;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final RacingCars racingCars;
    private final int matchCount;

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
    public List<List<CarInfoDto>> race(MovingStrategy movingStrategy) {
        final List<List<CarInfoDto>> scoreBoard = new ArrayList<>();

        for (int i = 0; i < this.matchCount; i++) {
            this.carMove(movingStrategy);
            scoreBoard.add(this.racingCars.carScore());
        }

        return scoreBoard;
    }

    private void carMove(MovingStrategy movingStrategy) {
        this.racingCars.carMove(movingStrategy);
    }
}