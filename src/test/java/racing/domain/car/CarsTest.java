package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.generator.DefaultNumberGenerator;
import racing.domain.generator.NumberGenerator;

public class CarsTest {

    NumberGenerator advanced = () -> 4;
    NumberGenerator notAdvanced = () -> 3;


    @Test
    @DisplayName("생성 테스트")
    void ctorTest() {
        //given
        List<Car> carList = List.of(
            new Car("1"),
            new Car("2"),
            new Car("3")
        );

        //then
        assertDoesNotThrow(() -> new Cars(carList, new DefaultNumberGenerator(10)));
    }

    @Test
    @DisplayName("전체 자동차 전진 테스트")
    void advanceCarTest() {
        //given
        String name = "name";
        List<Car> list = new ArrayList<>(List.of(new Car(0, name)));
        Cars cars = new Cars(list, advanced);

        //when
        Cars movedCars = cars.move();

        //then
        assertThat(movedCars).isEqualTo(new Cars(List.of(new Car(1, name))));
    }

    @Test
    @DisplayName("전체 자동차 전진 실패 테스트")
    void notAdvanceCarTest() {
        //given
        String name = "name";
        List<Car> list = new ArrayList<>(List.of(new Car(0, name)));
        Cars cars = new Cars(list, notAdvanced);

        //when
        Cars movedCars = cars.move();

        //then
        assertThat(movedCars).isEqualTo(cars);
    }

    @ParameterizedTest
    @MethodSource("winnerTest")
    @DisplayName("멀리간 운전자 찾기 테스트")
    void getWinner_Test(List<Car> winnerList, int people) {
        //given
        Cars cars = new Cars(winnerList, advanced);

        //when
        List<Name> farPeople = cars.farPeople();

        //then
        assertThat(farPeople.size()).isEqualTo(people);
    }

    private static Stream<Arguments> winnerTest() {
        return Stream.of(
            Arguments.of(List.of(
                new Car(0, "mang"),
                new Car(10, "winer")
            ), 1),
            Arguments.of(List.of(
                new Car(0, "mang"),
                new Car(10, "first"),
                new Car(10, "third")
            ), 2)
        );
    }
}
