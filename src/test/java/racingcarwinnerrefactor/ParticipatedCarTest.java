package racingcarwinnerrefactor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcarwinnerrefactor.domain.Car;
import racingcarwinnerrefactor.domain.Name;
import racingcarwinnerrefactor.domain.ParticipatedCars;
import racingcarwinnerrefactor.domain.Position;
import racingcarwinnerrefactor.exception.NullOrEmptyException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipatedCarTest {

    ParticipatedCars participatedCars;
    Car car1, car2, car3;

    @BeforeEach
    void setUp() {

        car1 = new Car(new Name("pobi"), new Position(5));
        car2 = new Car(new Name("crong"), new Position(5));
        car3 = new Car(new Name("honux"), new Position(3));

        participatedCars = new ParticipatedCars(Arrays.asList(new Car[]{car1, car2, car3}));
    }

    @Test
    void 우승자_찾기() {
        assertThat(participatedCars.findWinnerList()).containsExactly(car1, car2);
    }

    @Test
    void 자동차이름_빈문자열_예외() {
        assertThatThrownBy(() -> {
            ParticipatedCars participatedCars = new ParticipatedCars("");
        }).isInstanceOf(NullOrEmptyException.class);
    }

}
