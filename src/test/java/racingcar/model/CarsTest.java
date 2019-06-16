package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MockGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.MockGenerator.CarState.MAINTAIN;
import static racingcar.util.MockGenerator.CarState.RUN;

class CarsTest {

    private MockGenerator mockGenerator;
    private Cars cars;

    @Test
    @DisplayName("개수만큼 자동차를 생성한다")
    void carGenerator() {
        int count = 3;
        Cars generate = Cars.generate(count);
        assertThat(generate).isNotNull();
        assertThat(generate.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("임의의 값을 넘겨 자동차를 움직이게 한다")
    void moveACarSuccess() {
        mockGenerator = mockGenerator.generate(RUN, MAINTAIN, RUN);
        List<Car> carList = carList(3);
        cars = new Cars(carList, mockGenerator);
        List<Car> cars = this.cars.moveAll();
        assertThat(cars.get(0).getPosition()).isEqualTo(2);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(2);
    }

    static List<Car> carList(int count) {
        return IntStream.range(0, count).mapToObj(i -> new Car())
                .collect(Collectors.toCollection((Supplier<ArrayList>) ArrayList::new));
    }
}
