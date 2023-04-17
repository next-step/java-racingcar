package race.car;

import race.car.dto.CarInfoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 리뷰 참고하여 일급컬렉션 사용
 */
public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public void carMove(Random random) {
        for (Car car : this.racingCars) {
            car.move(random.nextInt(10));
        }
    }

    public List<CarInfoDto> carScore(){
        final List<CarInfoDto> carInfoDtos = new ArrayList<>();

        for (Car car : this.racingCars) {
            carInfoDtos.add(car.currentCarInfo());
        }

        return carInfoDtos;
    }
}
