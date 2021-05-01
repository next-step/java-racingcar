import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "자동차 테스트")
public class CarTest {

    private Car car;
    private final String CAR_NAME = "바나나차";

    @BeforeEach
    @DisplayName(value = "이름 조건 여부에 따라 자동차 생성이 가능하다")
    void setup() {
        car = Car.createCar(CAR_NAME);
    }

    @Test
    void matchDistance(){
        assertTrue(car.matchDistance(0));
    }

    @Test
    void matchName(){
        assertTrue(car.matchName(Setup.carName));
    }

    @Test
    void run() {
        car.run();
        assertTrue(car.matchDistance(1));
    }

    @Test
    void stop() {
        car.stop();
        assertTrue(car.matchDistance(0));
    }
}
