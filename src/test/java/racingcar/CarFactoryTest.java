package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    void createCar() {
        CarFactory factory = new CarFactory();
        List<Car> car = factory.createCar("pobi,woni,jun".split(","));
        assertThat(car.size()).isEqualTo(3);
    }
}