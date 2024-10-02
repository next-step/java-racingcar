package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
        car.setMoveStrategy(new RandomMoveStrategy());
    }

    @Test
    @DisplayName("랜덤 값이 4 미만일 경우, 상태가 변하지 않아야 한다.")
    void 랜덤값_4미만_멈춤() {
        String prevStatus = car.getStatus();
        car.run();

        assertThat(car.getStatus()).isEqualTo(prevStatus);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만일 경우, 상태가 변해야 하고, 상태에 -가 추가되어야 한다.")
    void 랜덤값_4이상_전진() {
        String prevStatus = car.getStatus();
        car.run();

        assertThat(car.getStatus()).isNotEqualTo(prevStatus);
        assertThat(car.getStatus()).isEqualTo("-");
    }

}
