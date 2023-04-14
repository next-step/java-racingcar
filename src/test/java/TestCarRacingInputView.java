import CarRacing.view.*;
import exception.NegativeInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCarRacingInputView {

    @Test
    @DisplayName("숫자체크 함수에서 숫자가 아닌 문자가 입력되었을 때 return false")
    public void isNumeric_text() {
        boolean actual = InputView.isNumeric("abc");
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("숫자체크 함수에서 숫자가 입력되었을 때 return true")
    public void isNumeric_number() {
        boolean actual = InputView.isNumeric("1");
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("숫자체크 함수에서 숫자와 문자가 혼합되어 입력되었을 때 return false")
    public void isNumeric_textAndNumber() {
        boolean actual = InputView.isNumeric("a1c");
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("문자가 들어왔을 때 IllegalArgumentException")
    public void getNumberOfCar_input_string() {
        assertThatThrownBy(() -> InputView.getNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음수가 들어왔을 때 NegativeInputException")
    public void getNumberOfCar_negative() {
        assertThatThrownBy(() -> InputView.getNumber("-5"))
                .isInstanceOf(NegativeInputException.class);
    }

    @Test
    @DisplayName("양수가 들어왔을 때 해당 숫자를 int 타입으로 return")
    public void getNumberOfCar_number() {
        int actual = InputView.getNumber("5");
        assertThat(actual).isEqualTo(5);
    }

    @Test
    @DisplayName("차량 이름 길이가 5자 초과하면 IlligalArgumentException 발생")
    public void car_name_above_5() {
        assertThatThrownBy(() -> InputView.getNameOfCars("aaa,bbbbbb,cccc,dddd,eeee,ffff"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
