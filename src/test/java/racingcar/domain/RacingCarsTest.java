package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarsTest {

    @Test
    @DisplayName("입력 받은 자동차 이름들을 콤마로 분리 (공백없음)")
    void split_car_name_when_no_blank() {
        //given
        RacingCars racingCars = new RacingCars("red,blue,green");
        //when
        //then
        List<Car> showCars = racingCars.showCars();
        assertAll(
                () -> assertThat(showCars).hasSize(3),
                () -> assertThat(showCars.get(0).showName()).isEqualTo("red"),
                () -> assertThat(showCars.get(1).showName()).isEqualTo("blue"),
                () -> assertThat(showCars.get(2).showName()).isEqualTo("green")
        );
    }

    @Test
    @DisplayName("입력 받은 자동차 이름들을 콤마로 분리 (공백있음)")
    void split_car_name_when_blank() {
        //given
        RacingCars racingCars = new RacingCars("red, blue, green");
        //when
        //then
        List<Car> showCars = racingCars.showCars();
        assertAll(
                () -> assertThat(showCars).hasSize(3),
                () -> assertThat(showCars.get(0).showName()).isEqualTo("red"),
                () -> assertThat(showCars.get(1).showName()).isEqualTo("blue"),
                () -> assertThat(showCars.get(2).showName()).isEqualTo("green")
        );

    }

    @Test
    @DisplayName("입력 받은 자동차 이름이 한개일 때 자동차 1개만 생성")
    void split_car_name_when_only_one() {
        //given
        RacingCars racingCars = new RacingCars("red");
        //when
        //then
        List<Car> showCars = racingCars.showCars();
        assertAll(
                () -> assertThat(showCars).hasSize(1),
                () -> assertThat(showCars.get(0).showName()).isEqualTo("red")
        );

    }

}