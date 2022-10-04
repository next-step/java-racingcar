package racing_car_with_winner.model;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void adf() {
        Car car = new Car(new CarName("123"));
        car.tryMove();
    }
}
