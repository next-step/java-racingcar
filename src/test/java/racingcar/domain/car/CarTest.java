package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @DisplayName("자동차는 Power가 true 면 이동하고 false 면 이동하지 않는다.")
    @ParameterizedTest
    @CsvSource({"true,1", "false,0"})
    void move(boolean movementStrategy, int location) {
        Car car = new Car("pobi");

        int actualLocation = car.move(() -> movementStrategy);

        assertThat(actualLocation).isEqualTo(location);
    }

    @DisplayName("자동차 이름에 null 또는 공백이 올경우 IllegalArgumentException throw")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyNameThrowException(String wrongName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(wrongName))
                .withMessage("이름은 Null 또는 공백이 될 수 없습니다.");
    }
}
