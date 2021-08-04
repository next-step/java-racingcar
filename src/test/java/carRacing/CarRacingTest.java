package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    private CarRacing carRacing;
    private String[] carNames;

    @BeforeEach
    void setUp() {
        carRacing = new CarRacing();
        carNames = new String[]{"star", "jae", "hong"};
    }

    @Test
    void start() {
        assertThatIllegalArgumentException().isThrownBy(() -> carRacing.start(null, 2));

        assertThatIllegalArgumentException().isThrownBy(() -> carRacing.start(carNames, 0));

        assertDoesNotThrow(() -> carRacing.start(carNames, 5));
    }

    @Test
    @DisplayName("레이싱 우승자를 구하는 로직 테스트")
    void getWinners() {
        ArrayList<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            Car car = new Car(name);
            car.go(() -> true);
            cars.add(car);
        }

        ArrayList<Car> winners = carRacing.getWinners(cars);
        assertThat(winners.containsAll(cars)).isEqualTo(true);
    }
}