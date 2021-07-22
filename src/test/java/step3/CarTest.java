package step3;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차가_전진하는지() {
        Car car = new Car(new CarEngine());
        car.move();
        car.showNowLocation();
        car.move();
        car.showNowLocation();
        car.move();
        car.showNowLocation();
        car.move();
    }
}
