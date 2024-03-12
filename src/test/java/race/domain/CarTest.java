package race.domain;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move() {
        int count = 100;
        Car car = Car.createInstance();
        for (int i = 0; i < count; i++) {
            car.move();
        }
        System.out.println(car.getCountOfMove());
    }
}