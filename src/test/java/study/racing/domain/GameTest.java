package study.racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class GameTest {

    @Test
    void 차량_초기위치_확인() {
        Game game = new Game(new Cars("car1"), 0);
        game.playGame();

        assertThat(game.getCars().getCar(0).getPosition()).isEqualTo(new CarPosition(0));
    }

    @Test
    void 게임_생성시_차량수_확인() {
        Cars cars = new Cars("car1", "car2");
        assertThat(cars.getCars()).hasSize(2);
    }


}