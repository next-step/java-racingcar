package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest(name = "조건에 따라 1칸 전진하는지 확인하는 테스트")
    @MethodSource("getForwardFuncTestSample")
    void 전진_기능_테스트(boolean condition, Car expected) {
        Car car = new Car("test");
        car.forward(() -> condition);

        assertThat(car).isEqualTo(expected);

    }

    private static Stream<Arguments> getForwardFuncTestSample() {

        String carName = "test";
        boolean condition1 = true;
        boolean condition2 = false;

        Car expected1 = new Car(carName);
        expected1.forward(() -> condition1);
        Car expected2 = new Car(carName);
        expected2.forward(() -> condition2);

        return Stream.of(
                Arguments.of(condition1, expected1),
                Arguments.of(condition2, expected2)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"invalidCarName", "''"})
    void car_객체_생성_테스트(String carName) {
        assertThatThrownBy(() -> {
            new Car(carName);
        }).isInstanceOf(RuntimeException.class);
    }
}

