package racingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    @DisplayName("이름이 5자 미만일 시 이름 return")
    void CarName_Correct_Length() {
        CarName carName = new CarName("pobi");
        assertThat(carName.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("이름이 5자 초과할 시 Exception 발생")
    void CarName_Length_Longer_Than_Five_Then_Exception() {
        assertThatThrownBy(() -> new CarName("Lionel Messi"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
