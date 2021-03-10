package step33;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car(new ArrayList<>());
    }

    @DisplayName("createCar를 정상적으로 호출했을 경우")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void createCarTest(int number) {
        assertDoesNotThrow(() -> car.createCar(number));
        assertEquals(car.carsSizes().size() , number);
    }


    @DisplayName("createCar를 한번 더 호출해서 exception을 띄울경우")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void createCarThrowException(int number) {
        car.createCar(number);

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> car.createCar(number));
    }

    @DisplayName("moveCars의 매개변수 isOver가 true일 경우 carSize 증가 확인")
    @Test
    void moveCarsTrueTest() {
        car.createCar(1);
        car.moveCars(true, 0);

        Assertions.assertEquals(car.carsSizes().get(0), 1);
    }

    @DisplayName("moveCars의 매개변수 isOver가 false일 경우 carSize 고정 확인")
    @Test
    void moveCarsFalseTest() {
        car.createCar(1);
        car.moveCars(false, 0);

        Assertions.assertEquals(car.carsSizes().get(0), 0);
    }

}