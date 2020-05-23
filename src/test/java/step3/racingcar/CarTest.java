package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.racingcar.domain.Car;
import step3.racingcar.domain.CarFactory;
import step3.racingcar.domain.RandomMovingStrategy;

import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("car 객체 생성 및 기본값 테스트")
    @Test
    public void makeNewCarObject() {
        Car car = new Car("abc", new RandomMovingStrategy());

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("car 객체가 움직이는지 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("mockCarFactory")
    public void checkWhetherCarObjectMoves(String[] carNames) {
        List<Car> cars = CarFactory.makeCars(carNames);

        cars.forEach(Car::move);

        assertThat(cars.stream().map(Car::getPosition))
                .containsAnyOf(0, 1);
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
