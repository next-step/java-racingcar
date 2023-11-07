package racewinner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racewinner.domain.Cars;
import racewinner.expteion.CarNameTooLongException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @DisplayName("Car의 name이 5글자 이상이면 CarNameTooLongException 발생한다.")
    @Test
    void carNameTooLong() {
        //given
        Cars carList = new Cars(null);

        //when
        //then
        assertThatThrownBy(() -> carList.add("simpsonsimpson"))
                .isInstanceOf(CarNameTooLongException.class);
    }

    @DisplayName("가장 높은 step의 자동차들이 리턴된다.")
    @Test
    void winnerTest() {
        //given
        Cars carList = new Cars(() -> 8);

        //when
        carList.add("bobo");
        carList.add("popo");
        List<String> winnerList = carList.findWinner();

        //then
        assertThat(winnerList).contains("bobo");
        assertThat(winnerList).contains("popo");
    }
}
