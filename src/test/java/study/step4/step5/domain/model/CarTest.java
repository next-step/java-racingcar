package study.step4.step5.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step5.domain.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    public void createCar() {
        this.car = new Car("coby");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 자동차_움직임확인() {
        assertThat(car.isMove(5)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3})
    public void 자동차_멈춤확인() {
        assertThat(car.isMove(5)).isTrue();
    }
}
