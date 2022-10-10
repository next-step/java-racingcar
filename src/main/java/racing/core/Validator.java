package racing.core;

import java.util.List;

public class Validator {
    public void validateCarNames(List<Car> cars) {
        cars.forEach(this::validateCarName);
    }

    private void validateCarName(Car car){
       String carName = car.getCarName();
       if(carName.length() > 5) throw new RuntimeException("car name is too long");
    }
}
