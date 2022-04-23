package racingcarwinner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcarwinner.domain.Car;
import racingcarwinner.domain.ParticipatedCars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipatedCarsTest {

    ParticipatedCars participatedCars;
    String[] names = {"a", "b", "c"};

    @BeforeEach
    void setUp() {
        participatedCars = new ParticipatedCars(names);

        List<Car> cars = participatedCars.getParticipatedCars();

        cars.get(0).move(() -> true);
        cars.get(0).move(() -> true);
        cars.get(0).move(() -> true);

        cars.get(1).move(() -> true);
        cars.get(1).move(() -> true);

        cars.get(2).move(() -> true);
    }

    @Test
    void 참가자동차_생성() {
        assertThat(participatedCars.getParticipatedCars()).hasSize(3);
    }

}
