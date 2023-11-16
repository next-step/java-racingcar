package study.racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingGameTest {

    private CarRacingGame game;

    @BeforeEach
    void 게임초기화(){
        this.game = new CarRacingGame();
    }

    @Test
    void createCarList() {
        assertThat(game.createCarList("aa,bb"))
                .contains(new Car("aa"));
    }

    @Test
    void 차량이름나누기테스트() {
        assertThat(game.nameSplit("aa,cd")).contains("aa");
    }

    @Test
    void 차량글자5자초과에러테스트() {
        assertThatThrownBy( () ->  game.checkNameLength("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}