package step4_winner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


class RaceTest {

    @Test
    @DisplayName("레이스에는 1대 이상의 차가 필요하다.")
    void raceMustPositiveCars() {
        // GIVEN empty list
        List<Car> cars = new ArrayList<>();
        // WHEN create
        Throwable illegalThrown = catchThrowable(() -> new Race(cars,1));
        // THEN
        assertThat(illegalThrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0이상이어야 함");

        // GIVEN positive
        cars.add(new Car("test1"));
        // WHEN
        Race legalRace = new Race(cars,1);
        // THEN
        assertThat(legalRace).isNotNull();
    }

    @Test
    @DisplayName("100개의 차가 참가한 race가 일단 열리면, 100대중 1개는 전진 한다")
    public void RaceRoundTest() {
        // GIVEN
        List<Car> cars = IntStream.range(0, 100)
                .mapToObj(i -> "c_" + (++i))
                .peek(System.out::println)
                .map(Car::new)
                .collect(Collectors.toList());
        Race race = new Race(cars,1);

        // WHEN
        race.runRound();

        // then
        boolean anyCarMoved = cars.stream().anyMatch(car -> car.getDistance() > 1);
        assertThat(anyCarMoved).isTrue();
    }

}