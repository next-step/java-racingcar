package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingManagerTest {

    final int NUMBER_OF_CAR = 5;

    RacingManager racingManager = new RacingManager(NUMBER_OF_CAR);

    @DisplayName("랜덤 숫자가 0~9사이에서 리턴되는지 테스트")
    @Test
    public void getRandomNumberTest() {

        int randomNumber = racingManager.getRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @DisplayName("3 미만일 경우에는 false, 이상일 경우 true 리턴 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,false", "9,true"})
    public void canMoveCarTest(int randomNumber, boolean result) {
        assertThat(racingManager.canMoveCar(randomNumber)).isEqualTo(result);
    }

    @DisplayName("레이싱 카 리스트가 만들어지는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void makeRacingCarTest(int numberOfCar) {
        RacingManager racingManager = new RacingManager(numberOfCar);
        assertThat(numberOfCar).isEqualTo(racingManager.getCarList().size());
    }
}
