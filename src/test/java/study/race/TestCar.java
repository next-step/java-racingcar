package study.race;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


public class TestCar {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @ParameterizedTest(name = "Car 객체의 전진 테스트")
    @ValueSource(ints = {7, 2, 3})
    public void test_car_move(int moveNum) {
        for (int i = 0; i < moveNum; i++) {
            car.move();
        }

        assertThat(car.getScore()).isEqualTo(moveNum);
    }


    @ParameterizedTest(name = "Car 객체 생성 테스트")
    @ValueSource(strings = {"car1", "car2", "car3"})
    public void test_car_name(String name) {
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }


    @ParameterizedTest(name = "Car 객체 생성 테스트 - 이름 Null 유효성")
    @NullAndEmptySource
    public void test_car_name_empty(String testCarName) {
        Throwable emptyException = assertThrows(IllegalStateException.class, () -> {
            new Car(testCarName);
        });

        assertThat(emptyException.getMessage()).isEqualTo("자동차 이름을 입력해주세요.");
    }

    
    @Test
    @DisplayName("Car 객체 생성 테스트 - 이름 최대 길이 유효성")
    public void test_car_name_max_length() {
        String testCarName = "123456";
        IllegalStateException maxLengthException = assertThrows(IllegalStateException.class, () -> {
            new Car(testCarName);
        });

        assertThat(maxLengthException.getMessage()).isEqualTo("자동차 이름은 1~5자만 가능합니다.");
    }

}
