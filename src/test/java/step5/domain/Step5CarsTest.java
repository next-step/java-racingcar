package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.car.Car;
import step5.domain.car.Cars;

import java.util.List;

public class Step5CarsTest {
    private Cars cars;

    @BeforeEach
    void settingCars(){
        // given
        String names = "포비, 그르릉, 아톰";

        // when
        cars = Cars.defaultOf(names);
    }

    @Test
    @DisplayName("시합 자동차 생성 테스트")
    void make_cars() {
        // then
        Assertions.assertThat(cars.hasSize(3)).isTrue();
    }

    @Test
    @DisplayName("승자 뽑기 테스트")
    void vote_winner() {
        // given
        Car 포비 = Car.defaultOf("포비", 3);
        Car 쿠키 = Car.defaultOf("쿠키", 4);
        Car 포우 = Car.defaultOf("포우", 4);
        Cars cars = Cars.defaultOf(List.of(포비, 쿠키, 포우));

        // when
        Cars winners = cars.voteWinner();

        // then
        Assertions.assertThat(winners.count()).isEqualTo(2);
    }
}
