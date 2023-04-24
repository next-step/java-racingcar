package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private step4.Cars carsWithOneWinner;
    private step4.Cars carsWithTwoWinner;
    private int bestScore;

    @BeforeEach
    void setUp() {
        bestScore = 3;
        String[] names = {"car1", "car2", "car3"};
        carsWithOneWinner = step4.Cars.of(names);
        carsWithOneWinner.moveCar(0, 1);
        carsWithOneWinner.moveCar(1, 2);
        carsWithOneWinner.moveCar(2, bestScore);


        String[] names2 = {"car1", "car2", "car3"};
        carsWithTwoWinner = step4.Cars.of(names2);
        carsWithTwoWinner.moveCar(0, 1);
        carsWithTwoWinner.moveCar(1, bestScore);
        carsWithTwoWinner.moveCar(2, bestScore);
    }

    @DisplayName("랜덤값이 4이상일때만 전진 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    public void Cars_전진테스트(int key, int value) {
        String[] names = {"1", "2"};
        Cars cars = Cars.of(names);
        cars.moveCars((() -> key >= 4), 1);
        for (Car car : cars.getCars()) {
            assertThat(car.isEqualsProgress(value)).isTrue();
        }
    }

    @Test
    public void 최고기록_구하기() {
        assertThat(carsWithOneWinner.getBestScore()).isEqualTo(bestScore);
    }

    @Test
    public void 승자_구하기() {
        assertThat(carsWithOneWinner.getWinners()).containsExactly("car3");
        assertThat(carsWithTwoWinner.getWinners()).containsExactly("car2", "car3");
    }
}
