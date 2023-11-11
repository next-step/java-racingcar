package study.carracing.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest {

    @Test
    @DisplayName("문자열의 콤마(,)를 기준으로 split한 배열의 length만큼 자동차가 생성된다.")
    void split_car_name() {
        RacingCars racingCars = new RacingCars();

        racingCars.addCar("car1,car2,car3".split(","));

        assertThat(racingCars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("꺼내온 자동차들의 값을 변경하면 UnsupportedOperationException예외가 발생한다.")
    void 불변테스트() {
        Racing racing = new Racing();
        racing.start("car1,car2,car3".split(","), 3);
        List<Car> racingCars = racing.getRacingCars();

        assertThatThrownBy(() -> racingCars.add(new Car(new Name("pobi"))))
                .isInstanceOf(UnsupportedOperationException.class);

    }
}