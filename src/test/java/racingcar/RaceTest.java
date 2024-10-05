package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
    }

    @Test
    @DisplayName("입력한 수 만큼의 자동차를 생성한다.")
    void 자동차_생성() {
        race.createCars(3);
        assertThat(race.getCars()).hasSize(3);
    }

//    @Test
//    @DisplayName("차량의 수에 맞게 차량을 생성하고, 랜덤값이 4 이상인 경우 상태가 변경되어야 한다.")
//    void 라운드_랜덤값_4이상() {
//
//        race.createCars(3);
//
//        MockRandom.setNextInt(6);
//        race.round();
//
//        List<Car> cars = race.getCars();
//        for (Car car : cars) {
//            assertThat(car.getStatus()).isEqualTo("-");
//        }
//
//    }
//
//    @Test
//    @DisplayName("차량의 수에 맞게 차량을 생성하고, 랜덤값이 4 미만인 경우 상태가 변경되지 않아야 한다.")
//    void 라운드_랜덤값_4미만() {
//
//        race.createCars(3);
//
//        MockRandom.setNextInt(2);
//        race.round();
//
//        List<Car> cars = race.getCars();
//        for (Car car : cars) {
//            assertThat(car.getStatus()).isEqualTo("");
//        }
//
//    }

}
