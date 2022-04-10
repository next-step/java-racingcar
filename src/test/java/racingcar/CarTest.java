package racingcar;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarTest {
    @ParameterizedTest
    @Order(1)
    @CsvSource({"9,4"})
    void 경주중_자동차가_전진하는_경우(int rangeEndNumber, int rangeStartNumber) {
        Car car = new Car();
        Random random = new Random();

        int generateNumber = random.nextInt(rangeEndNumber + 1) + rangeStartNumber;
        car.addMoveCount(generateNumber, 4);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @Order(2)
    @ValueSource(ints = {3})
    void 경주중_자동차가_멈춰있는_경우(int rangeEndNumber) {
        Car car = new Car();
        Random random = new Random();

        int generateNumber = random.nextInt(rangeEndNumber + 1);
        car.addMoveCount(generateNumber, 4);
        assertThat(car.getMoveCount()).isZero();
    }
}