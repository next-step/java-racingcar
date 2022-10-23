package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void inputCarExceptionTest() {
        assertThatThrownBy(() -> {
            new Car("123456");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void inputCarTest() {
        Car car = new Car("1234");

        assertThat(car.getName()).isEqualTo("1234");
        System.out.println(car.getPosition());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void getRandomNumTest() {
        RandomMoveRule randomMoveRule = new RandomMoveRule();
        assertThat(randomMoveRule.getRandomNum()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}
