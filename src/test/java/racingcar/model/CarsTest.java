package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MockGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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

    @DisplayName("자동차 생성 개수가 음수일 경우 실패")
    @Test
    void generateFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.generate(-1));
    }

    @Test
    @DisplayName("자동차가 모두 전진한다")
    void moveCarSuccess() {
        List<Car> carList = generateCarList(3);
        mockGenerator = mockGenerator.generate(RUN);
        cars = new Cars(carList, mockGenerator);

        List<Car> result = cars.moveAll();

        assertThat(result).extracting(Car::getPosition).contains(2);
    }

    @Test
    @DisplayName("자동차가 모두 움직이지 않는다")
    void nonMoveCar() {
        List<Car> carList = generateCarList(3);
        mockGenerator = mockGenerator.generate(MAINTAIN);
        cars = new Cars(carList, mockGenerator);

        List<Car> result = cars.moveAll();

        assertThat(result).extracting(Car::getPosition).contains(1);
    }

    static List<Car> generateCarList(int count) {
        return IntStream.range(0, count).mapToObj(i -> new Car()).collect(Collectors.toList());
    }
}
