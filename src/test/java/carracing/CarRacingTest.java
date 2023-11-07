package carracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static carracing.CarRacing.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {


    @Test
    void isMinus() {
        assertThatThrownBy(() -> carInputProcess("-1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputValid() {
        assertThatThrownBy(() -> carInputProcess("dd")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void normalReturn() {
        assertThat(carInputProcess("1")).isEqualTo(1);
    }

    @Test
    void nullOrBlank() {
        assertThat(carInputProcess("")).isEqualTo(0);
    }
}