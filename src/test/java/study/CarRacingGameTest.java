package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {

    CarRacingGame carRacingGame = null;

    @BeforeEach
    public void CarRacingGame(){
        carRacingGame = new CarRacingGame();
    }

    @Test
    @DisplayName("자동차 몇대를 할껀지 확인")
    public void testCarCnt(){
        assertThat(carRacingGame.confirmCarCnt(0)).isEqualTo(false);
        assertThat(carRacingGame.confirmCarCnt(1)).isEqualTo(true);
        assertThat(carRacingGame.confirmCarCnt(3)).isEqualTo(true);
    }

    @Test
    @DisplayName("몇번을 이동할껀지 확인")
    public void testMoveCnt(){
        assertThat(carRacingGame.confirmMoveCnt(0)).isEqualTo(false);
        assertThat(carRacingGame.confirmMoveCnt(1)).isEqualTo(true);
        assertThat(carRacingGame.confirmMoveCnt(5)).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차 대수만큼 생성 제대로 되는지 확인")
    public void testMakeCar(){
        assertThat(carRacingGame.initializeCar(3)).containsExactly("-", "-", "-");
        assertThat(carRacingGame.initializeCar(5)).containsExactly("-", "-", "-", "-", "-");
    }
}
