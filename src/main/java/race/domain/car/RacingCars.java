package race.domain.car;

import race.domain.car.dto.CarInfoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 리뷰 참고하여 일급컬렉션 사용
 */
public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public void carMove(MovingStrategy movingStrategy) {
        for (Car car : this.racingCars) {
            car.move(movingStrategy);
        }
    }

    public List<CarInfoDto> carScore() {
        final List<CarInfoDto> carInfoDtos = new ArrayList<>();

        for (Car car : this.racingCars) {
            carInfoDtos.add(car.currentCarInfo());
        }

        return carInfoDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}
