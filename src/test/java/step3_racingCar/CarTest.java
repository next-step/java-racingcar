package step3_racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;
    private static final int INITNUM = 0;

    @BeforeEach
    void setUp(){
        car = new Car();
    }
    
    @Test
    void createCar(){
        assertThat(car.getForwardNum()).isEqualTo(INITNUM);
    }
}
