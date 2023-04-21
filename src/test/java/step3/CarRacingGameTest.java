package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarRacingGameTest {
    private CarRacingGame carRacingGame;

    @BeforeEach
    void init() {
        carRacingGame = new CarRacingGame();
    }

    @Test
    @DisplayName("게임 플레이")
    void Test_play() {
        carRacingGame.play(new GameStartParameter(3, 7));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 100})
    void Given_GameStartParameters_When_generateCars_Then_cars_generated(int carNums) {
        // given
        GameStartParameter gameStartParameter = new GameStartParameter(carNums, 5);

        // when
        List<SimpleCar> cars = carRacingGame.generateCars(gameStartParameter);

        // then
        assertThat(cars.size()).isEqualTo(carNums);
    }
}
