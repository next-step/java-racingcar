package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarRacingGameTest {
    private CarRacingGame carRacingGame;
    private final MovingStrategy movingStrategy = new RandomMovingStrategy();

    @BeforeEach
    void init() {
        carRacingGame = new CarRacingGame(movingStrategy);
    }

    @Test
    @DisplayName("게임 플레이")
    void Test_play() {
        List<String> names = Arrays.asList("aaa", "bbb", "ccc");
        carRacingGame.play(new GameStartParameter(names, 7));
    }

    @Test
    void Given_GameStartParameters_When_generateCars_Then_cars_generated() {
        // given
        List<String> carNames = List.of("1", "22", "333", "4444", "55555");
        GameStartParameter gameStartParameter = new GameStartParameter(carNames, 5);

        // when
        List<SimpleCar> cars = carRacingGame.generateCars(gameStartParameter);

        // then
        assertThat(cars.size()).isEqualTo(carNames.size());
        assertThat(cars.stream().filter(it -> it.getCarName().equals("333")).findAny()).isPresent();
    }


    @Test
    void Given_CarNames_too_long_When_generateCars_Then_fail_to_generate_cars() {
        // given
        List<String> carNames = List.of("1", "22", "333", "4444", "55555", "666666");
        GameStartParameter gameStartParameter = new GameStartParameter(carNames, 5);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> carRacingGame.generateCars(gameStartParameter));
    }

}
