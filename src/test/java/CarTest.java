import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "자동차 테스트")
public class CarTest {

    private Car car;
    private final String CAR_NAME = "바나나차";

    @BeforeEach
    @DisplayName(value = "이름 조건 판단에 따른 자동차 생성")
    void setup() {
        car = Car.createCar(CAR_NAME);
    }

    @Test
    @DisplayName(value = "자동차 주행 거리 일치 여부")
    void matchDistance(){
        assertTrue(car.matchDistance(0));
    }

    @Test
    @DisplayName(value = "자동차 이름 일치 여부")
    void matchName(){
        assertTrue(car.matchName(CAR_NAME));
    }

    @Test
    @DisplayName(value = "자동차 전진 테스트")
    void run() {
        car.run();
        assertTrue(car.matchDistance(1));
    }

    @Test
    @DisplayName(value = "자동차 정지 테스트")
    void stop() {
        car.stop();
        assertTrue(car.matchDistance(0));
    }
}
