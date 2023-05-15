package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.InputParser;

public class CarTest {

    @Test
    @DisplayName("Car 생성시 초기 위치")
    public void getInitPositionOfCar() {
        Car car = new Car();
        assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1, 2, 3})
    @DisplayName("기준보다 작은 랜덤 숫자일때")
    public void stop(int randomNumber) {
        Car car = new Car();
        car.stopOrMove(randomNumber);
        assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 9})
    @DisplayName("기준보다 큰 랜덤 숫자일때")
    public void move(int randomNumber) {
        Car car = new Car();
        car.stopOrMove(randomNumber);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "4:1", "8:1", "3:0"}, delimiter = ':')
    @DisplayName("중지 혹은 전진 테스트")
    public void stopOrMove(String randomNumber, String position) {
        Car car = new Car();
        car.stopOrMove(InputParser.stringToInteger(randomNumber));
        assertThat(car.getPosition()).isEqualTo(InputParser.stringToInteger(position));
    }

    @Test
    @DisplayName("자동차 위치 계산 테스트")
    public void position() {
        int[] randomNumbers = {8, 4, 2, 1};
        Car car = new Car();
        Arrays.stream(randomNumbers).forEach(r -> car.stopOrMove(r));
        assertThat(car.getPosition()).isEqualTo(2);
    }

}
