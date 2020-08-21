package test;

import core.AlwaysMoveStrategy;
import core.AlwaysStopStrategy;
import core.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    
    @DisplayName("자동차 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"carName1","carName2"})
    void 자동차생성테스트(String carName) {
        Car testCar = Car.create(carName);
        assertThat(testCar.name).isEqualTo(carName);
    }

    @DisplayName("자동차 이름 입력 테스트(null값 / 공백 / 5자 초과)")
    @ParameterizedTest
    @ValueSource(strings = {"","123456"})
    void 자동차이름테스트(String carName) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car.validate(carName);
        });
    }

    @DisplayName("전진 테스트")
    @ParameterizedTest
    @MethodSource("createCar")
    void 전진테스트(Car car) {
        int beforePosition = car.position;
        car.carAction(new AlwaysMoveStrategy());
        assertThat(car.position).isEqualTo(beforePosition+1);
    }

    @DisplayName("멈춤 테스트")
    @ParameterizedTest
    @MethodSource("createCar")
    void 멈춤테스트(Car car) {
        int beforePosition = car.position;
        car.carAction(new AlwaysStopStrategy());
        assertThat(car.position).isEqualTo(beforePosition);
    }

    private static Stream<Car> createCar() {
        return Stream.of(Car.create("name1"),Car.create("name2"));
    }

}
