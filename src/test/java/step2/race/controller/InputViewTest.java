package step2.race.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private InputView inputView;

    private static Stream<Arguments> carNames() {
        return Stream.of(
                Arguments.of("pobi,chanin", Arrays.asList("pobi", "chanin")),
                Arguments.of("pobi,chanin,someone", Arrays.asList("pobi", "chanin", "someone"))
        );
    }

    private static Stream<String> illegalInput() {
        return Stream.of(" ", "    ");
    }

    @ParameterizedTest
    @MethodSource("carNames")
    void inputCarAmount_경기에_참여할_자동차_이름들_입력받기(String names, List<String> answer) {
        //given
        ByteArrayInputStream input = new ByteArrayInputStream(names.getBytes());
        inputView = new InputView(input);

        //when
        List<String> results = inputView.inputCarNames();

        //then
        assertThat(results).isEqualTo(answer);
    }

    @ParameterizedTest
    @MethodSource("illegalInput")
    void inputCarAmount_잘못된_입력(String input) {
        //given
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        inputView = new InputView(byteInput);

        assertThatThrownBy(() -> inputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(input + "는 올바른 입력이 아닙니다.");
    }

    @Test
    void inputCarAmount_최소_자동차보다_적은_수_입력시() {
        //given
        ByteArrayInputStream input = new ByteArrayInputStream("pobi".getBytes());
        inputView = new InputView(input);

        assertThatThrownBy(() -> inputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1보다 많은 수의 자동차가 필요합니다.");
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