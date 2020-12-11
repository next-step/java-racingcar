package cargameracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * UnitTest
 * @author minji
 */
public class CarTest {
    private CarRacingGame racingGame;
    private Car car;

    @BeforeEach
    void setUp() {
        racingGame = new CarRacingGame(3);
        car = new Car();
    }

    @Test
    @DisplayName("차의 개수 확인")
    void carCount() {
        assertThat(racingGame.cars.length).isEqualTo(3);
        assertThat(racingGame.getCars().length).isEqualTo(3);
    }

    @Test
    @DisplayName("차의 전진수 확인")
    void playGame() {
        assertThat(racingGame.cars[0].getJunjin()).isEqualTo(0);
        assertThat(racingGame.cars[1].getJunjin()).isEqualTo(0);
        assertThat(racingGame.cars[2].getJunjin()).isEqualTo(0);

    }

    @Test
    @DisplayName("랜덤값이 4 이상 값인지 체크")
    void randomValue() {
        int random = car.randomValue();
        System.out.println(random);
        assertThat(random).isGreaterThan(3);
    }
}