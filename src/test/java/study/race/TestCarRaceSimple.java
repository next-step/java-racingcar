package study.race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCarRaceSimple {

    @Test
    @DisplayName("Car 객체의 전진 조건 테스트 - 성공")
    public void test_car_move_condition_success() {
        int successNum = 4;
        Car car = new Car();
        car.move(successNum);

        assertThat(car.showHistory().length()).isEqualTo(1);
    }

    
    @Test
    @DisplayName("Car 객체의 전진 조건 테스트 - 실패")
    public void test_car_move_condition_fail() {
        int failNum = 3;

        Car car = new Car();
        car.move(failNum);

        assertThat(car.showHistory().length()).isEqualTo(0);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Car 객체의 전진 기록 테스트")
    public void test_car_move_history(int moveNum) {
        int randomNum = 4;

        Car car = new Car();
        for (int i = 0; i < moveNum; i++) {
            car.move(randomNum);
        }

        assertThat(car.showHistory().length()).isEqualTo(moveNum);
    }


    @ParameterizedTest
    @CsvSource({"2, 4", "4, 5", "3, 6"})
    @DisplayName("CarRace Car 개수 입력 테스트")
    public void test_carrace_carNum_tryNum_input(int carNum, int tryNum) {
        CarRace race = new CarRace(carNum, tryNum);

        assertThat(race.getCars().size()).isEqualTo(carNum);
    }

    
}
