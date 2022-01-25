package racingcar.model.domain;

import java.util.List;
import racingcar.model.entity.Car;

public class CarRegistration {

    private CarRegistration(final List<String> userInput, final Racing racing){
        run(userInput, racing);
    }

    public static CarRegistration instance(final List<String> userInput, final Racing racing){
        return new CarRegistration(userInput, racing);
    }

    public void run(final List<String> input, final Racing racing) {

        for (String carName : input) {
            racing.registerCar(Car.of(carName));
        }
    }
}

