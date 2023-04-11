package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
class RacingCarGameTest {
    @ParameterizedTest
    @DisplayName("주어진 수만큼 차를 만든다")
    @ValueSource(ints = {1, 2, 3})
    void create(int value) {
        RacingCarGame game = createRacingCarGame();
        game.createCars(value);

        assertThat(game.hasCars(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("양수가 들어가면 양수를 그대로 반환한다.")
    void positiveInputCount(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RacingCarGame game = createRacingCarGame();

        assertThat(game.inputCount()).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    @DisplayName("음수가 들어가면 예외를 발생시킨다.")
    void negativeInputCount(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RacingCarGame game = createRacingCarGame();

        assertThatThrownBy(game::inputCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi", "hello", "안녕"})
    @DisplayName("문자가 들어가면 예외를 발생시킨다.")
    void notNumberInputCount(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RacingCarGame game = createRacingCarGame();

        assertThatThrownBy(game::inputCount)
                .isInstanceOf(NumberFormatException.class);
    }

    private static RacingCarGame createRacingCarGame() {
        RacingCarGame game = new RacingCarGame(new Scanner(System.in));
        return game;
    }
}