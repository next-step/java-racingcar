package study.race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCarRaceSimple {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Car 객체의 전진 테스트")
    public void test_car_move(int moveNum) {
        Car car = new Car();

        for (int i = 0; i < moveNum; i++) {
            car.move();
        }

        assertThat(car.showHistory().length()).isEqualTo(moveNum);
    }
    
}
