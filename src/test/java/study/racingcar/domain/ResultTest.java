package study.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {


    GameCars cars;
    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("pobi", "crong", "honux", "junho");
        cars = new GameCars(carNames);
        for (Car car : cars) {
            if (car.getCarName().equals("pobi")) {
                car.move();
            }
            if (car.getCarName().equals("crong")) {
                car.move();
                car.move();
            }
            if (car.getCarName().equals("honux")) {
                car.move();
                car.move();
                car.move();
            }
            if (car.getCarName().equals("junho")) {
                car.move();
                car.move();
                car.move();
            }
        }
    }

    @DisplayName("winner가 두명일 경우 공동 우승 테스트")
    @Test
    void when_winner_is_two() {
        //given
        Result result = new Result(cars);

        // when
        String winners = result.winners();

        //then
        assertThat(winners).isEqualTo("honux,junho");
    }

    @DisplayName("winner가 한명일 경우 테스트")
    @Test
    void when_winner_is_one() {
        //given
        for (Car car : cars) {
            if (car.getCarName().equals("junho")) {
                car.move();
            }
        }
        Result result = new Result(cars);

        // when
        String winners = result.winners();

        //then
        assertThat(winners).isEqualTo("junho");
    }
}