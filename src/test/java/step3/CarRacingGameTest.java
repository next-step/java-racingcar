package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class CarRacingGameTest {

    private CarRacingGame carRacingGame;

    @BeforeEach
    void setUp() {
        this.carRacingGame = new CarRacingGame(2);
    }

    @Test
    void 자동차_두대_이상_경주생성() {
        CarRacingGame carRacingGame = new CarRacingGame(3);
        assertThat(carRacingGame.carsCount()).isEqualTo(3);
    }

    @Test
    void 자동차_두대_미만_경주생성_예외() {
        assertThatThrownBy(() -> new CarRacingGame(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 라운드_횟수_1이상_경주시작() {
        carRacingGame.start(5);
        assertThat(carRacingGame.carsCount()).isEqualTo(2);
    }

    @Test
    void 라운드_횟수_1미만_경주시작_예외() {
        assertThatThrownBy(() -> carRacingGame.start(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주_시작후_결과_조회() {
        carRacingGame.start(5);
        assertThatNoException().isThrownBy(() -> carRacingGame.result());
    }

    @Test
    void 경주_시작전_결과_조회시_예외() {
        assertThatThrownBy(() -> carRacingGame.result())
                .isInstanceOf(IllegalStateException.class);
    }
}
