package me.namuhuchutong.step4;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private static final String NEW_LINE = "\n";

    @BeforeEach
    void setUp() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
    }

    @DisplayName("공백이 아닌 이름과 숫자를 입력하면 사용자의 요청이 생성된다.")
    @Test
    void given_not_blank_string_and_number_should_success() {
        //given
        String givenNames = "a,b,c";
        String givenNumberOfCar = "5";
        String input = givenNames + NEW_LINE + givenNumberOfCar + NEW_LINE;
        System.setIn(convertForInputStream(input));
        InputView inputView = new InputView();

        //when
        UserRequest request = inputView.showPrompt();

        //then
        assertThat(request.getNames()).isEqualTo(givenNames);
        assertThat(request.getTimes()).isEqualTo(Integer.valueOf(givenNumberOfCar));
    }

    @DisplayName("자동차 이름은 공백일 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"\n123\n", " \n123\n"})
    void given_names_should_not_be_blank(String givenInput) {
        //given
        System.setIn(convertForInputStream(givenInput));
        InputView inputView = new InputView();

        //when, then
        assertThatThrownBy(inputView::showPrompt).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 수는 숫자만 입력할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,b\nasdd\n", "a,b\n123vd\n"})
    void given_times_should_be_number(String givenInput) {
        //given
        System.setIn(convertForInputStream(givenInput));
        InputView inputView = new InputView();

        //when, then
        assertThatThrownBy(inputView::showPrompt).isInstanceOf(IllegalArgumentException.class);
    }

    private static ByteArrayInputStream convertForInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
