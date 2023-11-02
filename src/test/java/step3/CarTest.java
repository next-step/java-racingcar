package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private Car car = new Car();

    @Test
    public void 랜덤값_0부터_9사이() {
        int random = car.random();
        assertThat(random).isBetween(RANDOM_MIN, RANDOM_MAX);
    }

}
