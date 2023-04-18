package race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    @ParameterizedTest(name = "이동 전략이 {0}이고 2번 움직이면 현재 위치는 {1}이다")
    @MethodSource("carsTestStubs")
    void 자동차들의_이동전략에_따라_움직이면_위치를_알_수_있다(MoveStrategy moveStrategy, List<Integer> positions) {
        //GIVEN
        List<CarName> carNameList = List.of(new CarName("a"), new CarName("b"), new CarName("c"));
        Cars cars = new Cars(carNameList, moveStrategy);

        //WHEN
        cars.moveAll();
        cars.moveAll();

        //THEN
        assertThat(cars.getCarList()
                .stream()
                .map(Car::getPosition)
                .collect(Collectors.toList())
        ).isEqualTo(positions);
    }

    @Test
    void 자동차들을_list형태로_제공할_수_있다() {
        List<CarName> carNameList = List.of(new CarName("a"), new CarName("b"), new CarName("c"));
        Cars cars = new Cars(carNameList, new TestHelper.AlwaysMoveStrategy());
        assertThat(cars.getCarList()).isInstanceOf(List.class);
        assertThat(cars.getCarList()
                .stream()
                .map(it -> it.getCarName().get())
                .toArray()
        ).containsExactly("a", "b", "c");
    }

    private static Stream<Arguments> carsTestStubs() {
        return Stream.of(
                Arguments.arguments(new TestHelper.AlwaysMoveStrategy(), List.of(2, 2, 2)),
                Arguments.arguments(new TestHelper.NeverMoveStrategy(), List.of(0, 0, 0))
        );
    }
}
