package racingcarwinnerrefactor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcarwinnerrefactor.domain.*;
import racingcarwinnerrefactor.exception.NoWinnerException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerTest {

    ParticipatedCars participatedCars;
    Car car1, car2, car3;

    @BeforeEach
    void setUp() {

        car1 = new Car(new Name("pobi"), new Position(0));
        car2 = new Car(new Name("crong"), new Position(0));
        car3 = new Car(new Name("honux"), new Position(0));

        participatedCars = new ParticipatedCars(Arrays.asList(new Car[]{car1, car2, car3}));
    }

    @Test
    void 우승자_없는경우_예외() {
        assertThatThrownBy(() -> {
            WinnerCars winnerCars = new WinnerCars(participatedCars);
        }).isInstanceOf(NoWinnerException.class);
    }
}
