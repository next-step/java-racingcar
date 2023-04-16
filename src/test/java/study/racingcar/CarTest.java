package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("횟수 만큼 전달하여 자동차가 해당 수만큼 움직였는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:pobi","2:crong","5:honux"}, delimiterString = ":")
    public void racingGame_move(int randomNum, String carName) {

        Car car = new Car(0, carName);

        for(int i = 0; i < randomNum; i++) {
            new RacingGame().move(car);
        }

        assertThat(car.currentPosition()).isEqualTo(randomNum);
    }
}
