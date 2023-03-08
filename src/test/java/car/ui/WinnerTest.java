package car.ui;

import car.domain.Car;
import car.domain.Cars;
import car.domain.Name;
import car.domain.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> participants = new ArrayList<>();
        participants.add(new Car(new Name("씽씽카"), new Position(5)));
        participants.add(new Car(new Name("쏘카"), new Position(1)));
        participants.add(new Car(new Name("그린카"), new Position(5)));
        cars = Cars.of(participants);
    }

    @Test
    void 자동차_경주_우승자를_구한다() {
        // when
        List<Winner> winners = cars.getWinners();

        // then
        assertThat(winners).hasSize(2);
    }
}
