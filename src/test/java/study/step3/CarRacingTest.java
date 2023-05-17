package study.step3;

import org.junit.jupiter.api.Test;
import study.step3.dto.Input;
import study.step3.move.AlwaysMove;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.atomicReferenceArray;

class CarRacingTest {

    @Test
    public void threeCarFiveTryTest() throws Exception {
        Input input = new Input(3, 5 );
        String[][] result = CarRacing.racing(input, new AlwaysMove());

        assertThat(result[4][0]).isEqualTo("-----");
        assertThat(result[4][1]).isEqualTo("-----");
        assertThat(result[4][2]).isEqualTo("-----");
    }

}