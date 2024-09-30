package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Car.EMPTY_NAME_ERROR;
import static racingcar.Car.INPUT_LENGTH_EXCEEDED_ERROR;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;
    @BeforeEach
    void setCar() {
        car = new Car("pobi");
    }
    @Test
    public void 전진_하는지() {
        car.setGoCar(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    public void 전진_안하는지() {
        car.setGoCar(1);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    public void 자동차이름_에러_확인(){
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_LENGTH_EXCEEDED_ERROR);

        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME_ERROR);
    }

}
