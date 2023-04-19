package study.race;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TestCar {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest(name = "Car 객체의 전진 테스트")
    @ValueSource(ints = {7, 2, 3})
    public void test_car_move(int moveNum) {
        for (int i = 0; i < moveNum; i++) {
            car.move();
        }

        assertThat(car.getScore()).isEqualTo(moveNum);
    }

    
    @ParameterizedTest(name = "Car 객체 이름 설정 테스트")
    @ValueSource(strings = {"car1", "car2", "car3"})
    public void test_car_name(String name) {
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }


    @ParameterizedTest(name = "Car 객체 이름 설정 유효성 테스트")
    @ValueSource(strings = {"", "  ", "123456"})
    public void test_car_name_validation(String name) {
        assertThrows(IllegalStateException.class, () -> {
            Car car = new Car(name);
        });
    }

}
