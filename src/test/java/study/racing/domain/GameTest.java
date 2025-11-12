package study.racing.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class GameTest {

    @Test
    void 차량_초기위치_확인() {
        Cars cars = new Cars(List.of("car1", "car2"));

        Game game = new Game(cars, 0);
        game.playGame();

        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
    }

    @Test
    void 게임_생성시_차량수_확인() {
        Cars cars = new Cars(List.of("car1", "car2"));
        assertThat(cars.getCars()).hasSize(2);
    }


}