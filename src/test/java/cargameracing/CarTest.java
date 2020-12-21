package cargameracing;

import cargameracing.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * UnitTest
 * @author minji
 */
public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("tico");
    }

    @Test
    @DisplayName("Interface 위임해서 랜덤값 4 이상인지 체크")
    void randomValue() {
/*
       car.junjinUp(new MovingStrategy() {
            @Override
            public boolean isMove() {
                return true;
            }
        });
*/
        car.junjinUp(() -> true);
        assertThat(car.getJunjin()).isEqualTo(1);
    }
}