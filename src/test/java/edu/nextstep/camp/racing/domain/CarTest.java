package edu.nextstep.camp.racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void init(){
        car = new Car("KBC");
    }

    @Test
    void 전진(){
        car.move(4);
        int currentPosition = car.currentPosition();

        assertThat(currentPosition).isEqualTo(1);
    }

    @Test
    void 정지(){
        car.move(2);
        int currentPosition = car.currentPosition();

        assertThat(currentPosition).isEqualTo(0);
    }
}
