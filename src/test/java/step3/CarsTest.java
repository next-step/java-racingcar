package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    class MockDice implements Dice {

        private int testNum;

        public MockDice(int testNum) {
            this.testNum = testNum;
        }

        @Override
        public int getRandomNum() {
            return testNum;
        }
    }

    @DisplayName("랜덤값이 4이상일때만 전진 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    public void Cars_전진테스트(int key, int value) {
        Cars cars = Cars.of(3);
        CarsTest.MockDice mockDice = new CarsTest.MockDice(key);
        cars.moveCars(mockDice);
        for (Car car : cars.getCars()) {
            assertThat(car.getProgress()).isEqualTo(value);
        }

    }
}
