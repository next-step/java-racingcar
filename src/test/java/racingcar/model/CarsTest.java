package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.MockGenerator;
import racingcar.util.MockGenerator.CarState;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    @Test
    @DisplayName("개수만큼 자동차를 생성한다")
    void carGenerator() {
        int count = 3;

        Cars generate = Cars.generate(count);

        assertThat(generate).isNotNull();
        assertThat(generate.getCars().size()).isEqualTo(3);
    }

    @DisplayName("자동차 생성 개수가 음수일 경우 실패")
    @Test
    void generateFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.generate(-1));
    }

    @DisplayName("모든 자동차를 동작시킨다.")
    @ParameterizedTest
    @CsvSource({
            "RUN, 2",
            "MAINTAIN, 1"
    })
    void nonMoveCar(ArgumentsAccessor param) {
        CarState state = param.get(0, CarState.class);
        int expectedPosition = param.getInteger(1);
        Cars cars = carsOf(state);

        List<Car> result = cars.moveAll();

        assertThat(result).extracting(Car::getPosition).contains(expectedPosition);
    }

    private static Cars carsOf(MockGenerator.CarState carState) {
        List<Car> carList = generateCarList(3);
        return new Cars(carList, MockGenerator.generate(carState));
    }

    static List<Car> generateCarList(int count) {
        return IntStream.range(0, count).mapToObj(i -> Car.create()).collect(Collectors.toList());
    }
}
