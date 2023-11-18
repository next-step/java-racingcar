package car.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private Car car;
    private static final int START_DISTANCE = 0;

    @BeforeEach
    void setUp() {
        car = new Car(START_DISTANCE, "car");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 랜덤숫자가_4미만이면_멈추는지_테스트(int randomNumber) {
        car.game(randomNumber);
        assertThat(car).isEqualTo(new Car(START_DISTANCE, "car"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 랜덤숫자가_4이상이면_전진하는지_테스트(int randomNumber) {
        car.game(randomNumber);
        assertThat(car).isEqualTo(new Car(1, "car"));
    }

    @Test
    public void 차끼리의_거리_비교_비교대상보다_클때_양수_반환테스트() {
        Car winnerCar = new Car(5, "win");
        Car loserCar = new Car(3, "lose");

        assertThat(winnerCar.compareToDistance(loserCar)).isGreaterThan(0);
    }

    @Test
    public void 같은_거리의_차끼리_거리_비교_TRUE_반환테스트() {
        Car winnerCar = new Car(5, "win");
        Car loserCar = new Car(5, "lose");

        assertThat(winnerCar.isSameDistance(loserCar)).isTrue();
    }
}
