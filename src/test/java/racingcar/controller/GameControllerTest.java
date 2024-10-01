package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {

    @Test
    @DisplayName("입력받은 자동차 대수의 크기를 가지고 있는 리스트를 반환하는지 검증")
    void 자동차배열_반환_크기검증() {
        GameController gameController = new GameController(3, 1);
        List<Car> cars = gameController.getCars();
        assertThat(cars).hasSize(3);
    }

    @Test
    @DisplayName("자동차 배열안에 Car 객체가 포함되어있는지 검증")
    void 자동차배열_반환_원소검증() {
        GameController gameController = new GameController(1, 1);
        List<Car> cars = gameController.getCars();
        assertThat(cars).containsOnly(new Car());
    }
}
