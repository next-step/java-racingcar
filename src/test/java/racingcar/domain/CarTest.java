package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car = new Car("benz");

    @DisplayName("이동")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource({"true,1", "false,0"})
    void move(boolean movable, int expected) {
        car.move(() -> movable);
        assertThat(car.getPosition()).isEqualTo(new Position(expected));
    }

    @DisplayName("같은 포지션 값 확인 메소드")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource({"1,true", "0,false"})
    void isSame(int position, boolean expected) {
        car.move(() -> true);
        assertThat(car.isSame(new Position(position))).isEqualTo(expected);
    }
}
