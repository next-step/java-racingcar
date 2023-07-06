package car;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.*;

import car.exceptions.NumberNegativeException;
import car.domain.model.Count;
import org.junit.jupiter.api.Test;

public class CountTest {

    @Test
    void 시도_횟수_정상_동작 () {
        // given
        int inputCount = 5;
        int expectedCout = 5;

        // when
        Count count = new Count(inputCount);

        // then
        assertThat(count).extracting(Count::getTryCount).isEqualTo(expectedCout);
    }

    @Test
    void 시도_횟수_감소 () {
        int userInputCount = 3;
        int expectedDecreaseCount = 2;

        Count count = new Count(userInputCount);
        count.decreaseTryCount();

        assertThat(count).extracting("tryCount").isEqualTo(expectedDecreaseCount);
    }

    @Test
    void 음수_횟수 () {
        int negativeCount = -1;

        assertThrows(NumberNegativeException.class, () -> new Count(negativeCount));
    }

}
