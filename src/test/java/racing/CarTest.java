package racing;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 전진_조건은_random_값이_4이상일_경우() {
        Car car = new Car();
        assertThat(car.currentPosition()).isEqualTo(0);
        int firstDiceResult = 4;
        car.move(firstDiceResult);
        assertThat(car.currentPosition()).isEqualTo(1);
        int secondDiceResult = 3;
        car.move(secondDiceResult);
        assertThat(car.currentPosition()).isEqualTo(1);
    }
}
