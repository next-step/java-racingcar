package race;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRaceTest {

    private final static int RANDOM_RANGE = 10;
    private RandomNumber randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new CarRandomNumber(RANDOM_RANGE);
    }

    @Test
    void 입력받은_자동차_대수와_횟수를_가지고_CarRace를_생성한다() {
        int carCount = 2;
        int tryCount = 2;

        List<Car> cars = List.of(
            new Car(randomNumberGenerator),
            new Car(randomNumberGenerator)
        );

        CarRace carRace = new CarRace(carCount, tryCount, cars);

        assertThat(carRace.getCars()).hasSize(carCount);
    }

    @Test
    void 레이스가_start되면_각_자동차마다_조건에_맞게_전진한다() {
        int carCount = 2;
        int tryCount = 2;

        FixedNumber goNumber = new FixedNumber(4);
        FixedNumber stayNumber = new FixedNumber(1);

        List<Car> cars = List.of(
            new Car(goNumber),
            new Car(stayNumber)
        );

        CarRace carRace = new CarRace(carCount, tryCount, cars);

        List<Car> raceResult = carRace.start();

        assertThat(raceResult).hasSize(carCount);
        assertThat(raceResult.get(0).getForwardResult()).isEqualTo(3);
        assertThat(raceResult.get(1).getForwardResult()).isEqualTo(1);
    }
}
