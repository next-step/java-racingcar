package racingcarwinner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcarwinner.Exception.NoWinnerException;
import racingcarwinner.domain.Car;
import racingcarwinner.domain.ParticipatedCars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipatedCarsTest {

    ParticipatedCars participatedCars;
    String[] names = {"a", "b", "c"};

    @BeforeEach
    void setUp() {
        participatedCars = new ParticipatedCars(names);
        List<Car> cars = participatedCars.getParticipatedCars();
    }

    @Test
    void 모든자동차_움직이지않은경우_우승자구할수없는예외() {
        assertThatThrownBy(() -> {
            participatedCars.getMaxPositionList();
        }).isInstanceOf(NoWinnerException.class);
    }
}
