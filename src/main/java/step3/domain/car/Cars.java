package step3.domain.car;

import step3.domain.power.Power;

import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class Cars {

    private final List<Car> cars;
    private final Power power;

    public Cars(List<Car> cars, Power power) {
        checkArgument(cars != null, "cars is required");
        checkArgument(power != null, "power is required");
        this.cars = cars;
        this.power = power;
    }

    public void go() {
        cars.forEach(car -> {
            int generatedPower = power.generatePower();
            car.go(generatedPower);
        });
    }

}
