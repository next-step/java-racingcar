package study.race;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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


    @ParameterizedTest
    @CsvSource({"2, 4", "4, 5", "3, 6"})
    @DisplayName("CarRace Car 개수 및 시도 횟수 테스트")
    public void test_carrace_carNum_tryNum_input(int carNum, int tryNum) {
        assertDoesNotThrow(() -> new CarRace(carNum, tryNum));
    }
    
}
