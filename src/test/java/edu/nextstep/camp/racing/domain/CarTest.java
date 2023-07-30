package edu.nextstep.camp.racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car("KBC");
    }

    @Test
    void 전진() {
        car.move(4);
        int currentPosition = car.currentPosition();

        assertThat(currentPosition).isEqualTo(1);
    }

    @Test
    void 정지() {
        car.move(2);
        int currentPosition = car.currentPosition();

        assertThat(currentPosition).isEqualTo(0);
    }

    @Test
    void 운전자_이름_길이_및_공백_검증() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new Car("RIDER1  ")),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new Car("   ")),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new Car("RIDER1234"))
        );
    }
}
