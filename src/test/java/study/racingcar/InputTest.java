package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    @DisplayName("숫자를 입력시 자동차 대수를 반환 해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2"})
    public void inputView_setCars_숫자(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(InputView.setCars()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("숫자를 입력시 게임 횟수를 반환 해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"5"})
    public void inputView_setGames_숫자(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(InputView.setGames()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("자동차 이름을 입력하면 해당 문자열을 반환 해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    public void inputView_CarNames(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(InputView.setCarNames()).isEqualTo(input);
    }

    @DisplayName("0이하의 수는 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -3, -1})
    public void inputValue_isNegativeNumberAndZero(int input) throws Exception {

        InputValue inputValue = new InputValue();

        Method method = InputValue.class.getDeclaredMethod("isNegativeNumberAndZero", int.class);
        method.setAccessible(true);

        try{
            method.invoke(inputValue, input);
        } catch (InvocationTargetException e) {
            assertEquals(InputMismatchException.class, e.getTargetException().getClass());
        }

    }

    @DisplayName("자동차 이름은 5글자를 넘을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"bbororo","jaewon","tester"})
    public void inputValue_isMoreThanFiveLength(String input) throws Exception {

        InputValue inputValue = new InputValue();

        Method method = InputValue.class.getDeclaredMethod("isMoreThanFiveLength", String.class);
        method.setAccessible(true);

        try{
            method.invoke(inputValue, input);
        } catch (InvocationTargetException e) {
            assertEquals(InputMismatchException.class, e.getTargetException().getClass());
        }

    }
}
