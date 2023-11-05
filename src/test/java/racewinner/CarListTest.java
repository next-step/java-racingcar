package racewinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racewinner.expteion.CarNameTooLongException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarListTest {

    @DisplayName("Car의 name이 5글자 이상이면 CarNameTooLongException 발생한다.")
    @Test
    void carNameTooLong() {
        //given
        CarList carList = new CarList();

        //when
        //then
        assertThatThrownBy(() -> carList.add("simpsonsimpson"))
                .isInstanceOf(CarNameTooLongException.class);
    }
}
