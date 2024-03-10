package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move() {
        int count = 100;
        Car car = new Car();
        for (int i = 0; i < count; i++) {
            car.move();
        }
        System.out.println(car);
    }
}