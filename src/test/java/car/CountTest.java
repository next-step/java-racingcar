package car;

import car.view.model.Count;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountTest {

    @Test
    void 시도_횟수_정상_동작 () {
        // given
        String inputCount = "5";
        int expectedCout = 5;

        // when
        Count count = new Count(inputCount);

        // then
        Assertions.assertThat(count).extracting("tryCount").isEqualTo(expectedCout);
    }

}
