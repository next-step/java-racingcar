package racingcar.fixture;

import racingcar.domain.Car;

public class CarFixture {

    public static Car car() {
        return new Car(CarNameFixture.DEFAULT);
    }
}
