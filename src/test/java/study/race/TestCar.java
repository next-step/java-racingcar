package study.race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TestCar {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }
    
    @Test
    @DisplayName("Car 객체의 전진 조건 테스트 - 성공")
    public void test_car_move_condition_success() {
        int successNum = 4;
        car.move(successNum);

        assertThat(car.getScore().length()).isEqualTo(1);
    }


    @Test
    @DisplayName("Car 객체의 전진 조건 테스트 - 실패")
    public void test_car_move_condition_fail() {
        int failNum = 3;
        car.move(failNum);

        assertThat(car.getScore().length()).isEqualTo(0);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Car 객체의 전진 기록 테스트")
    public void test_car_move_history(int moveNum) {
        int successNum = 4;
        for (int i = 0; i < moveNum; i++) {
            car.move(successNum);
        }

        assertThat(car.getScore().length()).isEqualTo(moveNum);
    }

}
