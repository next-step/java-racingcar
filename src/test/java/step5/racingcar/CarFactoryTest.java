package step5.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step5.racingcar.domain.Car;
import step5.racingcar.domain.CarFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @DisplayName("CarFactory에서 Car 객체를 정상적으로 생성하고 개수 및 이름이 일치하는지 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("mockCarFactory")
    public void makeCarFromCarFactory(String[] carNames) {
        List<Car> cars = CarFactory.makeCars(carNames);

        List<String> testTargetCarNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());;
        List<String> originCarNames = Arrays.asList(carNames);

        assertThat(testTargetCarNames).isEqualTo(originCarNames);
    }

    private static Stream<Arguments> mockCarFactory() {
        return Stream.of(
                Arguments.of((Object) new String[]{"a", "b", "c", "d", "e"}),
                Arguments.of((Object) new String[]{"java", "js", "python", "go"}),
                Arguments.of((Object) new String[]{"a"}),
                Arguments.of((Object) new String[]{"java","js","python","r"})
        );
    }
}
