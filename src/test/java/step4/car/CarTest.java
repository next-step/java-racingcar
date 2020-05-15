package step4.car;

import org.junit.jupiter.api.BeforeEach;

public class CarTest {

    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    public void setUp(){
        car1 = Car.of("car1");
        car2 = Car.of("car2");
        car3 = Car.of("car3");
    }


}
