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

    @ParameterizedTest(name = "음수 또는 숫자 이외의 값이 전달되면 RuntimeException을 반환한다.")
    @ValueSource(strings = {"a","-1"})
    void input_Number_Of_Cars(String given) {
        System.setIn(new ByteArrayInputStream(given.getBytes()));

        Assertions.assertThatThrownBy(() -> racingGame.inputNumberOfCar()).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "몇번의 이동을 할 것인지 입력한다")
    @ValueSource(ints = {1,22,333})
    void input_Number_Of_Round(Integer number) {
        System.setIn(new ByteArrayInputStream(number.toString().getBytes()));
        racingGame.inputNumberOfRound();

        Assertions.assertThat(racingGame.round()).isEqualTo(number);
    }

    @ParameterizedTest(name = "음수 또는 숫자 이외의 값이 전달되면 RuntimeException을 반환한다.")
    @ValueSource(strings = {"a","-1"})
    void input_Number_Of_Round_Exception(String given) {
        System.setIn(new ByteArrayInputStream(given.getBytes()));

        Assertions.assertThatThrownBy(() -> racingGame.inputNumberOfRound()).isInstanceOf(RuntimeException.class);
    }
}
