import CarRacing.view.*;
import CarRacing.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCarRacing {

    Racing racing = new Racing();

    InputView inputView = new InputView();
    @Test
    @DisplayName("숫자체크 함수에서 숫자가 아닌 문자가 입력되었을 때 return false")
    public void isNumeric_text() {
        boolean actual = inputView.isNumeric("abc");
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("숫자체크 함수에서 숫자가 입력되었을 때 return true")
    public void isNumeric_number() {
        boolean actual = inputView.isNumeric("1");
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("숫자체크 함수에서 숫자와 문자가 혼합되어 입력되었을 때 return false")
    public void isNumeric_textAndNumber() {
        boolean actual = inputView.isNumeric("a1c");
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("차량 대수 입력 시 문자가 들어왔을 때 RuntimeException")
    public void getNumberOfCar_input_string() {
        assertThatThrownBy(() -> inputView.getNumberOfCar("a"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("차량 대수 입력 시 숫자가 들어왔을 때 해당 숫자를 int 타입으로 return")
    public void getNumberOfCar_number() {
        int actual = inputView.getNumberOfCar("5");
        assertThat(actual).isEqualTo(5);
    }

    @Test
    @DisplayName("시도 횟수 입력 시 문자가 들어왔을 때 RuntimeException")
    public void getNumberOfTry_input_string() {
        assertThatThrownBy(() -> inputView.getNumberOfTry("a"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("시도 횟수 입력 시 숫자가 들어왔을 때 해당 숫자를 int 타입으로 return")
    public void getNumberOfTry_number() {
        int actual = inputView.getNumberOfTry("7");
        assertThat(actual).isEqualTo(7);
    }

    @Test
    @DisplayName("4보다 적은 수 입력 시 차량 이동 없음")
    public void drive_less_4() {
        int actual = racing.drive(3);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("4보다 큰 수 입력 시 차량 이동")
    public void drive_more_4() {
        int actual = racing.drive(5);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("4 입력 시 차량 이동")
    public void drive_equal_4() {
        int actual = racing.drive(4);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("racing 함수에 차량 대수가 음수로 입력되었을 시 최종적으로 RuntimeException 발생 확인")
    public void racing_number_of_car_is_negative() {
        assertThatThrownBy(() -> racing.racing(-1, 1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("racing 함수에 시도 횟수가 음수로 입력되었을 시 최종적으로 RuntimeException 발생 확인")
    public void racing_number_of_try_is_negative() {
        assertThatThrownBy(() -> racing.racing(3, -2))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("racing 함수에 차량 대수와 시도 횟수 모두 양수로 입력 시 정상 수행 확인")
    public void racing_run_normally() {
        racing.racing(3, 5);
    }

}
