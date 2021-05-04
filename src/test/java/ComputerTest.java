import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("컴퓨터 기능 테스트")
class ComputerTest {

    Computer computer;
    Car car;
    final String CAR_NAME = "바나나차";

    @BeforeEach
    void setup(){
        computer = new Computer(new Cars());
        car = Car.createCar(CAR_NAME);
    }

    @Test
    @DisplayName("자동차 전진 혹은 정지 테스트")
    void play() {
        computer.play();
        assertTrue(car.matchDistance(0) || car.matchDistance(1));
    }
}