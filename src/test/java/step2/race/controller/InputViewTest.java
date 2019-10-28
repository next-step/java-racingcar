package step2.race.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private InputView inputView;

    private static Stream<String> illegalInput() {
        return Stream.of(" ", "    ");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void inputCarAmount_경기에_참여할_자동차_수_입력받기(String carAmount, Integer answer) {
        //given
        ByteArrayInputStream input = new ByteArrayInputStream(carAmount.getBytes());
        inputView = new InputView(input);

        //when
        int result = inputView.inputCarAmount();

        //then
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @MethodSource("illegalInput")
    void inputCarAmount_잘못된_입력(String input) {
        //given
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        inputView = new InputView(byteInput);

        assertThatThrownBy(() -> inputView.inputCarAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(input + "는 올바른 입력이 아닙니다.");
    }

    @Test
    void inputCarAmount_최소_자동차보다_적은_수_입력시() {
        //given
        ByteArrayInputStream input = new ByteArrayInputStream("0".getBytes());
        inputView = new InputView(input);

        assertThatThrownBy(() -> inputView.inputCarAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0보다 많은 수의 자동차가 필요합니다.");
    }

    @Test
    void inputMoveAmount_최소_시도횟수보다_적게_입력시() {
        //given
        ByteArrayInputStream input = new ByteArrayInputStream("0".getBytes());
        inputView = new InputView(input);

        assertThatThrownBy(() -> inputView.inputMoveAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0보다 많은 수의 시도 횟수가 필요합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void inputMoveAmount(String moveAmount, Integer answer) {
        //given
        ByteArrayInputStream input = new ByteArrayInputStream(moveAmount.getBytes());
        inputView = new InputView(input);

        //when
        int result = inputView.inputMoveAmount();

        //then
        assertThat(result).isEqualTo(answer);
    }
}