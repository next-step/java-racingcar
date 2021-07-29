package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingManagerTest {
    
    @DisplayName("랜덤 숫자가 0~9사이에서 리턴되는지 테스트")
    @Test
    public void getRandomNumberTest() {

        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        int randomNumber = randomMovingStrategy.getRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @DisplayName("레이싱 카 리스트가 만들어지는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void makeRacingCarTest(int numberOfCar) {
        RacingManager racingManager = new RacingManager(numberOfCar);
        assertThat(numberOfCar).isEqualTo(racingManager.getCarList().size());
    }
}
