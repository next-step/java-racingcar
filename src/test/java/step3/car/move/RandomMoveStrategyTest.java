package step3.car.move;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.RandomCreator;
import step3.RandomNumberCreator;
import step3.car.Car;

import static org.junit.jupiter.api.Assertions.*;

class RandomMoveStrategyTest {


    @DisplayName("입력받은수가 4이상이고 9이하이면 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "2,0", "4,1", "9,1", "10,0"})
    void randomMove(int moveNumber, int actualResult) {
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(() -> moveNumber);

        Car car = new Car(randomMoveStrategy);
        car.move();
        int result = car.getPosition();

        Assertions.assertThat(result).isEqualTo(actualResult);
    }
}
