package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.vo.Name;
import racing.domain.vo.Position;
import racing.util.MovableNumberGenerator;
import racing.util.NonMovableNumberGenerator;
import racing.util.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("문자열 하나로 자동차 여러개 생성 테스트")
    void createCarsWithSingleStringTest(){
        // Given
        final String carNamesStrings = "lee,park,kim";
        // When
        Cars cars = new Cars(carNamesStrings);
        // Then
        assertThat(cars.cars()).hasSize(3);
    }

    @Test
    @DisplayName("숫자가 4보다 작으면 위치를 그대로 유지")
    void doNotMoveIfNumberIstSmallerThanFour() {
        // Given
        final Car leeCar = new Car(new Name("lee"), new Position(1));
        final Car parkCar = new Car(new Name("park"), new Position(2));
        final Cars cars = new Cars(List.of(leeCar, parkCar));
        // When
        cars.move(3);
        // Then
        assertThat(leeCar.getPosition()).isEqualTo(1);
        assertThat(parkCar.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자가 4보다 크면 전진")
    void moveIfNumberIstGreaterThanAndEqualToFour() {
        // Given
        final Car leeCar = new Car(new Name("lee"), new Position(1));
        final Car parkCar = new Car(new Name("park"), new Position(2));
        final Cars cars = new Cars(List.of(leeCar, parkCar));
        // When
        cars.move(5);
        // Then
        assertThat(leeCar.getPosition()).isEqualTo(2);
        assertThat(parkCar.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자 찾기 테스트")
    void findWinnersTest() {
        // Given
        final Car leeCar = new Car(new Name("lee"), new Position(1));
        final Car parkCar = new Car(new Name("park"), new Position(2));
        final Car kimCar = new Car(new Name("kim"), new Position(2));
        final Cars cars = new Cars(List.of(leeCar, parkCar, kimCar));
        // When
        Winners winners = cars.findWinners();
        // Then
        assertThat(winners.winners()).containsExactlyInAnyOrder(parkCar, kimCar);
    }
}
