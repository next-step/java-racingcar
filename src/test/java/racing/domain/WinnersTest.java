package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.vo.Name;
import racing.domain.vo.Position;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    @DisplayName("우승자 찾기")
    void findWinnersTest() {
        // Given
        final Car leeCar = new Car(new Name("lee"), new Position(3));
        final Car parkCar = new Car(new Name("park"), new Position(2));
        final Car kimCar = new Car(new Name("kim"), new Position(3));
        final Cars cars = new Cars(List.of(
                leeCar,
                parkCar,
                kimCar));
        //When
        Winners winners = cars.findWinners();
        List<Car> actual = winners.winners();
        //Then
        assertThat(actual).containsExactlyInAnyOrder(leeCar, kimCar);
    }
}
