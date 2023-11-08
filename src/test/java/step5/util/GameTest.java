package step5.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step5.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @ParameterizedTest
    @MethodSource("makeCarsProvider")
    @DisplayName("makeCars 메서드는 입력으로 들어온 배열의 크기만큼 RacingCar 객체가 들어있는 List를 반환한다.")
    void testMakeCarsReturnList(String[] carNames, int expectedSize) {
        //given
        //when
        final List<RacingCar> cars = Game.makeCars(carNames);

        //then
        assertThat(cars).hasSize(expectedSize);
    }

    public static Stream<Arguments> makeCarsProvider() {
        return Stream.of(
                Arguments.of(new String[]{"car1", "car2", "car3"}, 3),
                Arguments.of(new String[]{"car1", "car2", "car3", "car4", "car5"}, 5)
        );
    }

    @Test
    @DisplayName("extractWinners 메서드는 입력으로 들어온 List 중에서 가장 먼 거리를 간 RacingCar들을 뽑아 List로 반환한다.")
    void testExtractWinnersList() {
        //given
        final RacingCar car1 = getRacingCarWithNameAndDistance("car1", 1);
        final RacingCar car2 = getRacingCarWithNameAndDistance("car2", 2);
        final RacingCar car3 = getRacingCarWithNameAndDistance("car3", 3);
        final RacingCar car4 = getRacingCarWithNameAndDistance("car4", 3);
        final List<RacingCar> cars = new ArrayList<>(List.of(car1, car2, car3, car4));

        //when
        final List<RacingCar> winners = Game.extractWinners(cars);

        //then
        assertThat(winners).containsExactly(car3, car4);
    }

    @Test
    @DisplayName("toNames 메서드는 입력으로 들어온 RacingCar들의 carName만을 뽑아 배열로 반환한다.")
    void toNames() {
        //given
        final List<RacingCar> cars = new ArrayList<>(List.of(
                new RacingCar("car1"),
                new RacingCar("car2")));

        //when
        final String[] carNames = Game.toNames(cars);

        //then
        assertThat(carNames).containsExactlyInAnyOrder("car1", "car2");
    }

    private RacingCar getRacingCarWithNameAndDistance(final String carName, final int moveDistance) {
        final RacingCar car = new RacingCar(carName);
        final int mustMoveValue = 9;

        for (int i = 0; i < moveDistance; i++) {
            car.moveIfInRange(mustMoveValue);
        }

        return car;
    }
}
