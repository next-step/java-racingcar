package racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Winners;
import racing.domain.vo.Name;
import racing.domain.vo.Position;
import racing.util.MovableNumberGenerator;
import racing.util.NonMovableNumberGenerator;
import racing.util.NumberGenerator;
import racing.util.StringSplitter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {


    @Test
    @DisplayName("자동차 움직임 테스트")
    void startMovingTest(){
        // Given
        final Car leeCar = new Car(new Name("lee"));
        final Car parkCar = new Car(new Name("park"));
        final NumberGenerator numberGenerator = new MovableNumberGenerator();
        final Cars cars = new Cars(List.of(leeCar, parkCar));
        final Race race = new Race(cars, numberGenerator);
        // When
        race.startMoving();
        // Then
        assertThat(leeCar.getPosition()).isEqualTo(1);
        assertThat(parkCar.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 조회 테스트")
    void getCarsTest() {
        // Given
        final Car leeCar = new Car(new Name("lee"));
        final Car parkCar = new Car(new Name("park"));
        final NumberGenerator numberGenerator = new MovableNumberGenerator();
        final Cars cars = new Cars(List.of(leeCar, parkCar));
        final Race race = new Race(cars, numberGenerator);
        // When
        Cars racingCars = race.getCars();
        // Then
        assertThat(racingCars.cars()).hasSize(2);
    }

    @Test
    @DisplayName("우승자 조회 테스트")
    void getWinnersTest() {
        // Given
        final Car leeCar = new Car(new Name("lee"), new Position(1));
        final Car parkCar = new Car(new Name("park"), new Position(2));
        final Car kimkCar = new Car(new Name("kim"), new Position(2));
        final NumberGenerator numberGenerator = new MovableNumberGenerator();
        final Cars cars = new Cars(List.of(leeCar, parkCar, kimkCar));
        final Race race = new Race(cars, numberGenerator);
        // When
        Winners winnerCars = race.getWinners();
        // Then
        assertThat(winnerCars.winners()).hasSize(2);
        assertThat(winnerCars.winners()).containsExactlyInAnyOrder(parkCar, kimkCar);
    }
}
