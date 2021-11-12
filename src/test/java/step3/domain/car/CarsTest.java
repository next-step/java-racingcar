package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static final int INTERVAL = 1;
    private static final int CAR_COUNT = 3;
    private static final int ROUND_COUNT = 3;
    private static final Location LOOSER_LOCATION = Location.placeOn(0);
    private static final Location WINNER_LOCATION = Location.placeOn(100);

    @DisplayName("공동 우승자 잘 구하는지 테스트")
    @Test
    void findWinnerNames() {
        //given
        Car winner = new Car(WINNER_LOCATION, new Name("짱구"));
        Car otherWinner = new Car(WINNER_LOCATION, new Name("길동"));
        Car looser = new Car(LOOSER_LOCATION, new Name("패자"));

        Cars cars = new Cars(asList(winner, otherWinner, looser));

        //when
        Winners winners = cars.findWinners();

        //then
        assertThat(winners).isEqualTo(new Winners(asList(winner, otherWinner)));
    }

    @DisplayName("단일 우승자 잘 구하는지 테스트")
    @Test
    void findWinnerNames2() {
        //given
        Car winner = new Car(WINNER_LOCATION, new Name("짱구"));
        Car looser = new Car(LOOSER_LOCATION, new Name("패자"));
        Car otherLooser = new Car(LOOSER_LOCATION, new Name("길동"));

        Cars cars = new Cars(asList(winner, otherLooser, looser));

        //when
        Winners winners = cars.findWinners();

        //then
        assertThat(winners).isEqualTo(new Winners(singletonList(winner)));
    }

    @DisplayName("전진, 정지 잘하는지 테스트")
    @ParameterizedTest
    @MethodSource(value = "generateGoInputs")
    void goTest(int inputPower, int moveDistance) {
        //given
        int location = 3;
        List<Car> inputCars = createCars(location);
        Cars cars = new Cars(inputCars);

        //when
        for (int i = 0; i < ROUND_COUNT; i++) {
            cars.go(() -> inputPower);
        }

        //when
        List<Car> expectedCars = createCars(location + moveDistance);
        assertThat(inputCars).isEqualTo(expectedCars);
    }

    private static Stream<Arguments> generateGoInputs() {
        return Stream.of(
                Arguments.of(3, 0),
                Arguments.of(4, INTERVAL * ROUND_COUNT)
        );
    }

    private List<Car> createCars(int location) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < CAR_COUNT; i++) {
            cars.add(new Car(Location.placeOn(location, INTERVAL)));
        }
        return cars;
    }

}
