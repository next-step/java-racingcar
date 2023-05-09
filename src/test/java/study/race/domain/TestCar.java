package study.race.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import study.race.domain.Car;


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
        assertThatThrownBy(() -> new Car(testCarName))
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("자동차 이름을 입력해주세요.");
    }

    
    @Test
    @DisplayName("Car 객체 생성 테스트 - 이름 최대 길이 유효성")
    public void test_car_name_max_length() {
        String testCarName = "123456";
        assertThatThrownBy(() -> new Car(testCarName))
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("자동차 이름은 1~5자만 가능합니다.");
    }

}
