package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameV1Test {

    @Test
    @DisplayName("차 대수 1, 시행 횟수 1를 입력하면 -를 list로 반환한다.")
    void racing_create_car_1_try_2() {
        //given
        RacingGameV1 game_v1 = new RacingGameV1(1, 1);
        List<String> carMarks = List.of("-");
        Car testCar = new Car(carMarks);
        //when
        List<Car> result = game_v1.start();
        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isIn(testCar);
    }

    @Test
    @DisplayName("차 대수 1, 시행 횟수 2를 입력하면 시행 횟수 만큼 -를 list로 반환한다.")
    void racing_create_car_1_try2() {
        //given
        RacingGameV1 game_v1 = new RacingGameV1(1, 2);
        //when
        List<Car> result = game_v1.start();
        //then
        assertThat(result.get(0)).isEqualTo(new Car(List.of("-", "-")));
    }

    @Test
    @DisplayName("차 대수 2, 시행 횟수 2를 입력하면 시행 횟수 만큼 -를 list 반환하고. 차 대수만큼 list에 넣어 반환한다.")
    void racing_create_car_2_try_2() {
        //given
        RacingGameV1 game_v1 = new RacingGameV1(2, 2);
        Car car = new Car(List.of("-", "-"));
        //when
        List<Car> result = game_v1.start();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0)).isEqualTo(car);
        assertThat(result.get(1)).isEqualTo(car);
    }
}
