package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("자동차 추가 확인")
    void testAddRacingCar() {
        RacingCar car1 = new RacingCar("amy");
        RacingCar car2 = new RacingCar("coni");
        RacingGame game = new RacingGame();
        game.addRacingCar(car1);
        game.addRacingCar(car2);

        assertThat(game.getCarList().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("최대 이동값 구하기 확인")
    void testGetMaxPosition() {
        RacingCar car1 = new RacingCar("amy");
        RacingCar car2 = new RacingCar("coni");
        RacingCar car3 = new RacingCar("tom");
        RacingGame game = new RacingGame();
        game.addRacingCar(car1);
        game.addRacingCar(car2);
        game.addRacingCar(car3);

        car1.run(() -> true);
        car1.run(() -> true);
        car2.run(() -> true);
        car2.run(() -> false);
        car3.run(() -> false);
        car3.run(() -> false);

        assertThat(game.getMaxPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자 구하기 확인")
    void testGetWinner() {
        RacingCar car1 = new RacingCar("amy");
        RacingCar car2 = new RacingCar("coni");
        RacingCar car3 = new RacingCar("tom");
        RacingGame game = new RacingGame();
        game.addRacingCar(car1);
        game.addRacingCar(car2);
        game.addRacingCar(car3);

        car1.run(() -> true);
        car1.run(() -> true);
        car2.run(() -> true);
        car2.run(() -> true);
        car3.run(() -> false);
        car3.run(() -> false);

        assertThat(game.getWinner()).contains("amy", "coni");
    }

}