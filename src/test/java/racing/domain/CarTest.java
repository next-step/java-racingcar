package racing.domain;

import com.racing.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("입력한 숫자 만큼 '-'를 반복하여 반환")
    public void isEquals_RepeatDash() {
        Car car = new Car(6, "");
        String expected = "------";

        assertThat(car.displayState()).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력한 CarName을 반환")
    public void isEquals_CarName() {
        String expected = "poby";
        Car car = new Car(6, "poby");

        assertThat(car.displayCarName()).isEqualTo(expected);
    }
}
