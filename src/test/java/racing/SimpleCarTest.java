package racing;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class SimpleCarTest {

    @Test
    void 전진_조건은_random_값이_4이상일_경우() {
        SimpleCar simpleCar = new SimpleCar();
        assertThat(simpleCar.currentPosition()).isEqualTo(0);
        int firstDiceResult = 4;
        simpleCar.move(firstDiceResult);
        assertThat(simpleCar.currentPosition()).isEqualTo(1);
        int secondDiceResult = 3;
        simpleCar.move(secondDiceResult);
        assertThat(simpleCar.currentPosition()).isEqualTo(1);
    }
}
