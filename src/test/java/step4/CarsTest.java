package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {


    @DisplayName("랜덤값이 4이상일때만 전진 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    public void Cars_전진테스트(int key, int value) {
        String[] names = {"1", "2"};
        Cars cars = Cars.of(names);
        MockDice mockDice = new MockDice(key);
        cars.moveCars(mockDice);
        for (Car car : cars.getCars()) {
            assertThat(car.getProgress()).isEqualTo(value);
        }
    }

    @Test
    public void 최고기록_구하기() {
        //car.progress 설정
    }

    @Test
    public void 승자_구하기() {
        //car.progress 설정
    }
}
