package controller;

import domain.Car;
import domain.GameRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;
    private GameRole gameRole;
    private Car myCar;

    @BeforeEach
    public void setup() {
        gameRole = new GameRole(new ArrayList<>(), 3);
        racingGame = new RacingGame(gameRole);
        myCar = new Car("myCar");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void tryMoveWithSmallerThanFourConditionCarDoesNotMove(int condition) {
        // Given
        int location = myCar.getCurrentLocation();
        // When
        racingGame.tryMoveCar(myCar, condition);
        // Then
        assertThat(myCar.getCurrentLocation()).isEqualTo(location);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void tryMoveWithGreaterThanFourConditionCarMoves(int condition) {
        // Given
        int location = myCar.getCurrentLocation();
        // When
        racingGame.tryMoveCar(myCar, condition);
        // Then
        assertThat(myCar.getCurrentLocation()).isEqualTo(location + 1);
    }


}
