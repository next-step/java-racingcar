package step5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.domain.Car;
import step5.domain.CarEngine;
import step5.domain.CarStadium;
import step5.domain.Referee;
import step5.strategy.SpeedMovingStrategy;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarStadiumTest {

    @CsvSource(value = {"4:3:Pobi:3", "3:3:hoho:0"}, delimiter = ':')
    @ParameterizedTest(name = "자동차 스피드가 {0}이고_{1}회_시도하면_간_거리는_{3}이다")
    void moveCars(int givenSpeed, int givenTryCnt, String name, int movedResultCount) {
        // Given
        List<Car> givenCars = new ArrayList<>();
        givenCars.add(new Car(name, new CarEngine(), new SpeedMovingStrategy(givenSpeed)));
        CarStadium carStadium = new CarStadium(new Referee(givenTryCnt), givenCars);

        List<Car> expectedCars = carStadium.getAllCars();

        // When
        for (int i = 0; i < givenTryCnt; i++) {
            carStadium.moveCars();
        }

        // Then
        assertThat(expectedCars.get(0).getMovedCount()).isEqualTo(movedResultCount);
    }
}