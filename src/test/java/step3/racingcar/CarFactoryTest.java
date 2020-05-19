package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @DisplayName("CarFactory에서 Car 객체를 정상적으로 생성하는 테스트")
    @ParameterizedTest
    @MethodSource("mockCarFactory")
    public void makeCarFromCarFactory(String[] carNames) {
        List<Car> cars = CarFactory.makeCars(carNames);
        int carNamesLength = carNames.length;
        for (int i = 0; i < carNamesLength; i++) {
            assertThat(cars.get(i).getName()).isEqualTo(carNames[i]);
        }

    }

    private static Stream<Arguments> mockCarFactory() {
        return Stream.of(
                Arguments.of((Object) "a,b,c,d,e".split(",")),
                Arguments.of((Object) "j,a,k".split(",")),
                Arguments.of((Object) "a".split(",")),
                Arguments.of((Object) "java,js,python,r".split(","))
                );
    }
}
