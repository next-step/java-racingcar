package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;
import racing.domain.RandomMovement;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void 차_생성() {
        car = new Car(new RandomMovement());
    }

//    @ParameterizedTest
//    @CsvSource({"1,0", "4,1", "2,1", "8,2", "6,3"})
    @Test
    void 차의_누적거리() {
//        assertThat(car.accumulateOneRound(input)).isEqualTo(expected);
        assertThat(car.accumulateOneRound(1)).isEqualTo(0);
        assertThat(car.accumulateOneRound(4)).isEqualTo(1);
        assertThat(car.accumulateOneRound(2)).isEqualTo(1);
        assertThat(car.accumulateOneRound(8)).isEqualTo(2);
        assertThat(car.accumulateOneRound(6)).isEqualTo(3);
    }
}
