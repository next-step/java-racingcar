package step5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.domain.Car;
import step5.domain.CarEngine;
import step5.domain.CarStadium;
import step5.domain.Referee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarStadiumTest {

    @CsvSource(value = {"4:3:Pobi:3", "3:3:hoho:0"}, delimiter = ':')
    @ParameterizedTest(name = "자동차 스피드가 {0}이고_{1}회_시도하면_간_거리는_{3}이다")
    void moveCars(int givenSpeed, int givenTryCnt, String name, int movedResultCount) {
        // Given
        List<Car> givenCars = new ArrayList<>();
        givenCars.add(new Car(name, new CarEngine(), new SpeedMovingStrategyTest(givenSpeed)));
        CarStadium carStadium = new CarStadium(new Referee(givenTryCnt), givenCars);

        List<Car> expectedCars = carStadium.getAllCars();

        // When
        for (int i = 0; i < givenTryCnt; i++) {
            carStadium.moveCars();
        }

        // Then
        assertThat(expectedCars.get(0).getMovedCount()).isEqualTo(movedResultCount);
    }

    @Test
    void winners() {
        // Given
        Car expectedWinner = new Car("pobi", new CarEngine(), new SpeedMovingStrategyTest(5));
        List<Car> givenCars = new ArrayList<>();

        givenCars.add(expectedWinner);
        givenCars.add(new Car("jason", new CarEngine(), new SpeedMovingStrategyTest(2)));
        givenCars.add(new Car("dudu", new CarEngine(), new SpeedMovingStrategyTest(3)));
        givenCars.add(new Car("godu", new CarEngine(), new SpeedMovingStrategyTest(1)));

        CarStadium carStadium = new CarStadium(new Referee(3), givenCars);

        carStadium.moveCars();

        // When
        List<Car> winners = carStadium.winners();

        // Then
        assertThat(winners).isEqualTo(Collections.singletonList(expectedWinner));
    }
}