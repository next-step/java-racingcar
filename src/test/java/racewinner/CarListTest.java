package racewinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racewinner.expteion.CarNameTooLongException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarListTest {

    @DisplayName("Car의 name이 5글자 이상이면 CarNameTooLongException 발생한다.")
    @Test
    void carNameTooLong() {
        //given
        CarList carList = new CarList(null);

        //when
        //then
        assertThatThrownBy(() -> carList.add("simpsonsimpson"))
                .isInstanceOf(CarNameTooLongException.class);
    }

    @DisplayName("가장 높은 step의 자동차들이 리턴된다.")
    @Test
    void winnerTest() {
        //given
        CarList carList = new CarList(() -> true);

        //when
        carList.add("bobo");
        carList.add("popo");
        List<String> winnerList = carList.findWinner();

        //then
        assertThat(winnerList).contains("bobo");
        assertThat(winnerList).contains("popo");
    }
}
