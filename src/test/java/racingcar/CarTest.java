package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.MoveType;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private static final String[] invalidName = {null, "", " ", "abcdef"};

    @ParameterizedTest
    @DisplayName("차량 정지 및 전진 테스트")
    @EnumSource(value = MoveType.class)
    void testMoveCar(MoveType moveType) {
        Car car = new Car("test");
        car.move(moveType);

        assertThat(car.getPosition()).isEqualTo(moveType.getMovePosition());
    }

    @ParameterizedTest
    @DisplayName("5글자를 초과하거나 빈 문자열, null, whitespace가  올 경우 예외 발생")
    @MethodSource("invalidCarName")
    void testInvalidCarName(String invalidName) {
        assertThatThrownBy(() -> new Car(invalidName)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("이름이 같은 경우 같은 자동차로 판단하는 지 테스트")
    void testDuplicateCarName() {
        String name = "test";
        Car fowardCar = new Car(name);
        Car stopCar = new Car(name);

        fowardCar.move(MoveType.FORWARD);

        assertThat(fowardCar).isEqualTo(stopCar);

    }

    static List<String> invalidCarName() {
        return Arrays.asList(invalidName);
    }

}
