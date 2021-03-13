package carRacing.domain;

import carRacing.dto.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarFactoryTest {

    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        this.carFactory = new CarFactory();
    }

    @Test
    @DisplayName("자동차를 원하는 숫자만큼 초기화해서 생성할 수 있다")
    void prepareCarsReturn() {
        for (int count = 0; count <= 100; count++) {
            UserInput userInput = new UserInput(count, count);
            List<Car> cars = carFactory.initCars(userInput);
            assertEquals(cars.size(), count);
        }
    }

}