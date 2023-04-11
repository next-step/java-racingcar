package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("랜덤 수를 전달하여 4이상인 경우 차가 움직이는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "7:1", "2:0", "4:1"}, delimiter = ':')
    public void generateRandomNum_범위내에_있는지_테스트(int randomNum, int length) {

        Car car = new Car("");
        //car.move(randomNum);

        assertThat(car.getPosition().length()).isEqualTo(length);
    }
}
