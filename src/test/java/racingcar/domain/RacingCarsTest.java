package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarsTest {

    @Test
    @DisplayName("입력 받은 자동차 이름들을 콤마로 분리 (공백없음)")
    void split_car_name_when_no_blank() {
        //given
        RacingCars racingCars = RacingCars.of("red,blue,green");
        //when
        //then
        assertAll(
                () -> assertThat(racingCars.size()).isEqualTo(3),
                () -> assertThat(racingCars.contains(new Car("red"))).isTrue(),
                () -> assertThat(racingCars.contains(new Car("blue"))).isTrue(),
                () -> assertThat(racingCars.contains(new Car("green"))).isTrue()
        );
    }

    @Test
    @DisplayName("입력 받은 자동차 이름들을 콤마로 분리 (공백있음)")
    void split_car_name_when_blank() {
        //given
        RacingCars racingCars = RacingCars.of("red, blue, green");
        //when
        //then
        assertAll(
                () -> assertThat(racingCars.size()).isEqualTo(3),
                () -> assertThat(racingCars.contains(new Car("red"))).isTrue(),
                () -> assertThat(racingCars.contains(new Car("blue"))).isTrue(),
                () -> assertThat(racingCars.contains(new Car("green"))).isTrue()

        );

    }

    @Test
    @DisplayName("입력 받은 자동차 이름이 한개일 때 자동차 1개만 생성")
    void split_car_name_when_only_one() {
        //given
        RacingCars racingCars = RacingCars.of("red");
        //when
        System.out.println(racingCars.showGraph(""));
        //then
        assertAll(
                () -> assertThat(racingCars.size()).isEqualTo(1),
                () -> assertThat(racingCars.contains(new Car("red"))).isTrue()
        );

    }

    @Test
    @DisplayName("우승자가 1명일 때")
    void one_winner() {
        //given
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("1", ((min, max) -> 9));
        car1.run(1);
        Car car2 = new Car("2", ((min, max) -> 9));
        car2.run(2);
        Car car3 = new Car("3", ((min, max) -> 9));
        car3.run(3);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingCars racingCars = new RacingCars(cars);
        //when
        Winners winners = racingCars.pickWinners();

        //then
        Assertions.assertAll(
                () -> assertThat(winners.size()).isEqualTo(1),
                () -> assertThat(winners.contain(car3)).isTrue(),
                () -> assertThat(winners.contain(car2)).isFalse()
        );
    }

    @Test
    @DisplayName("우승자가 여러 명 일 때")
    void several_winners() {
        //given
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("1", ((min, max) -> 9));
        car1.run(1);
        Car car2 = new Car("2", ((min, max) -> 9));
        car2.run(3);
        Car car3 = new Car("3", ((min, max) -> 9));
        car3.run(3);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingCars racingCars = new RacingCars(cars);
        //when
        Winners winners = racingCars.pickWinners();

        //then
        Assertions.assertAll(
                () -> assertThat(winners.size()).isEqualTo(2),
                () -> assertThat(winners.contain(car3)).isTrue(),
                () -> assertThat(winners.contain(car2)).isTrue(),
                () -> assertThat(winners.contain(car1)).isFalse()
        );

    }
}