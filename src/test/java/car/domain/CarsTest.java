package car.domain;

import car.ui.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

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
    void 일급객체가_관리하는_자동차의_크기를_구한다() {
        assertThat(cars.getParticipants()).hasSize(3);
    }

    @Test
    void 자동차_경주_우승자를_구한다() {
        // when
        List<Winner> winners = cars.getWinners();

        // then
        assertThat(winners).hasSize(2);
    }

    @Test
    void 자동차_경주_최대_위치값을_구한다() {
        // when
        int maxPosition = cars.getMaxPosition();

        // then
        assertThat(maxPosition).isEqualTo(5);
    }
}
