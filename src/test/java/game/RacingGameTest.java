package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setRacingGame(){
        racingGame = new RacingGame();
    }

    @ParameterizedTest(name = "자동차의 대수를 입력한다")
    @ValueSource(ints = {1,22,333})
    void input_Number_Of_Cars(Integer number) {
        System.setIn(new ByteArrayInputStream(number.toString().getBytes()));
        racingGame.inputNumberOfCar();

        Assertions.assertThat(racingGame.cars()).isEqualTo(number);
    }
}
