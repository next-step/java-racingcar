package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void move() {
        Car car = new Car();
        int moveCount = 4;
        IntStream.rangeClosed(1, moveCount).forEach(i -> car.move());
        assertThat(car.getPosition()).isEqualTo(moveCount);
    }
}
