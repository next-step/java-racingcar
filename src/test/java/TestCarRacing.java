import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCarRacing {
    @Test
    public void isNumeric_text() {
        boolean actual = CarRacing.isNumeric("abc");
        assertThat(actual).isEqualTo(false);
    }

    @Test
    public void isNumeric_number() {
        boolean actual = CarRacing.isNumeric("1");
        assertThat(actual).isEqualTo(true);
    }

    @Test
    public void isNumeric_textAndNumber() {
        boolean actual = CarRacing.isNumeric("a1c");
        assertThat(actual).isEqualTo(false);
    }

    @Test
    public void getNumberOfCar_input_string() {
        assertThatThrownBy(() -> CarRacing.getNumberOfCar("a"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getNumberOfCar_negative() {
        int actual = CarRacing.getNumberOfCar("-1");
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void getNumberOfCar_positive() {
        int actual = CarRacing.getNumberOfCar("5");
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void getNumberOfTry_input_string() {
        assertThatThrownBy(() -> CarRacing.getNumberOfTry("a"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getNumberOfTry_negative() {
        int actual = CarRacing.getNumberOfTry("-2");
        assertThat(actual).isEqualTo(-2);
    }

    @Test
    public void getNumberOfTry_positive() {
        int actual = CarRacing.getNumberOfTry("7");
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void drive_less_4() {
        int actual = CarRacing.drive(3);
        assertThat(actual).isEqualTo(0);
    }


    @Test
    public void drive_more_4() {
        int actual = CarRacing.drive(5);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void drive_equal_4() {
        int actual = CarRacing.drive(4);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void racing_number_of_car_is_negative() {
        assertThatThrownBy(() -> CarRacing.racing(-1, 1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void racing_number_of_try_is_negative() {
        assertThatThrownBy(() -> CarRacing.racing(3, -2))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void racing_run_normally() {
        CarRacing.racing(5, 20);
    }

}
