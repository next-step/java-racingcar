package edu.nextstep.camp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void create() {
        Car car = new Car();
        assertThat(car.position()).isEqualTo(Position.ofZero());
    }
}
