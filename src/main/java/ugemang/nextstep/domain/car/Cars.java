package ugemang.nextstep.domain.car;

import ugemang.nextstep.domain.message.RacingGameMessageEnum;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateExistsCars(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateExistsCars(List<Car> cars) {
        if(cars.size() <= 1){
            throw new IllegalArgumentException(String.format(RacingGameMessageEnum.E4.getMessage(), cars.size()));
        }
    }
}
